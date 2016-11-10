package cn.com.cisec.cheyoumei.server.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.model.PhoneCode;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.service.IPhoneCodeService;
import cn.com.cisec.cheyoumei.server.service.IUserService;
import cn.com.cisec.cheyoumei.server.util.NumberValidationUtils;
import cn.com.cisec.cheyoumei.server.util.ProjectState;

@Controller
public class PhoneCodeController {
	@Autowired
	private IPhoneCodeService iPhoneCodeService;
	@Autowired
	private IUserService iUserService;
	/**
	 * @标题: mobileLogin 
	 * @描述: 用户提交验证码到服务器,服务器验证手机验证码是否过期,是否正确,不正确就重新发送-然后从新验证,正确就注册成功
	 * @参数 @param phoneNum
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @throws 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月3日 下午5:21:03
	 */
	@RequestMapping("mobileLogin")
	@ResponseBody
	public Object mobileLogin(String mobilePhone,String verifyCode){
		Map<String,Object> map = new HashMap<String, Object>();
		if (mobilePhone==null||"".equals(mobilePhone)||"null".equals(mobilePhone)||verifyCode==null||"".equals(verifyCode)||"null".equals(verifyCode)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		//1.判断验证码是否正确,是否过期
		List<PhoneCode> listphoneCode = iPhoneCodeService.findUsermobilePhone(mobilePhone);
		if (listphoneCode.isEmpty()) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		} 
		for (PhoneCode pc : listphoneCode) {
			String code = pc.getCode(); //获取验证码
			Date time = pc.getBeforeAt();
			Date nowTime = new Date();
			System.out.println("这个是BeforeAt获取的过期时间"+time+"======"+time.getTime());
			System.out.println("这个是mobileLogin获取的登陆时间"+nowTime+"======"+nowTime.getTime());
			if (verifyCode.equals(code)&& (nowTime.getTime()<time.getTime())) {
				User userObject = iUserService.findUser(mobilePhone);
				if (userObject == null) {
					iUserService.addUser(mobilePhone);
					userObject = iUserService.findUser(mobilePhone);
				}
				map = mapPackage(userObject);
			}else{
				map.put(ProjectState.STATECODE, ProjectState.FAILED);
			}
		}
		return map;
	}
	private Map<String, Object> mapPackage(User userObject) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map.put(User.ID,userObject.getId());
		map.put(User.USERNAME,userObject.getUserName());
		map.put(User.MOBLIEPHONE,userObject.getMobilePhone());
		map.put(User.LOGOURL,userObject.getLogoUrl());
		map.put(User.BALANCE,userObject.getBalance());
		return map;
	}
	/**
	 * @标题: mobileVerifyCode 
	 * @描述: 手机四位验证码生成存储到数据库,并转发给移动端,由移动端转发给用户
	 * @参数 @param phoneNum
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @throws 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月4日 上午8:57:26
	 */
	@RequestMapping("mobileVerifyCode")
	@ResponseBody
	public Object mobileVerifyCode(String mobilePhone){
		Map<String,Object> map = new HashMap<String, Object>();
		if (mobilePhone==null||"".equals(mobilePhone)||"null".equals(mobilePhone)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		PhoneCode phoneCode = new PhoneCode();
		String verifyCode = getVerifyCode();//获取验证码
		//1.查询user表是否有此用户
		List<PhoneCode> listphoneCode = iPhoneCodeService.findUsermobilePhone(mobilePhone);
		System.out.println("listphoneCode:"+listphoneCode);
		if (listphoneCode.isEmpty()) {
			System.out.println("没有元素");
			//如果没有此手机号,添加用户到PhoneCode表中
			phoneCode.setMobliePhone(mobilePhone);
			phoneCode.setCode(verifyCode);
			Date createTime = new Date();
			long time = createTime.getTime()+120*1000;
			System.out.println("验证码生成时间："+createTime);
			System.out.println("验证码过期时间："+time);
			Date invalidTime = new Date(time);
			phoneCode.setCreatedAt(createTime);
			phoneCode.setBeforeAt(invalidTime);
			iPhoneCodeService.addPhoneCode(phoneCode);
			//发送验证码和手机号到运营商
			//TODO
			map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
			return map;
			}
			//2.如果有此用户
		for (PhoneCode pc : listphoneCode) {
			String phoneNum = pc.getMobliePhone();
			//如果有此手机号,更新验证码,更新时间,更新过期时间
			if (phoneNum.equals(mobilePhone)) {
				int id = pc.getId(); //获取phoneCode的验证码
				Date createTime = new Date();
				long time = createTime.getTime()+120*1000;
				Date invalidTime = new Date(time);
				iPhoneCodeService.updatePhoneCode(id,mobilePhone,verifyCode,createTime,invalidTime);
				//发送验证码和手机号到运营商
				//TODO
				map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
			}
		}
		return map;
	}
	/**
	 * @标题: mobile_Login 
	 * @描述: 手机用户登录(已有用户登录)
	 * @参数 @param mobilePhone
	 * @参数 @param loginPwd
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月10日 下午4:05:32
	 */
	@RequestMapping("mobileUserLogin")
	@ResponseBody
	public Object mobile_Login(String mobilePhone,String loginPwd){
		Map<String,Object> map = new HashMap<String,Object>();
		if (mobilePhone==null||loginPwd==null||"".equals(mobilePhone)||"".equals(loginPwd)||"null".equals(mobilePhone)||"null".equals(loginPwd)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		//1.查询数据库中是否有该用户
		User user = iUserService.findUser(mobilePhone);
		//如果用户不存在或者用户名和密码不正确,不是活动用户返回登录失败
		if (user==null||!mobilePhone.equals(user.getMobilePhone())||!loginPwd.equals(user.getLoginPwd())||!user.isActived()) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		//2.查询密码是否正确,如果正确返回用户数据,主要返回用户的id,用户头像地址,用户余额(balance)
		 map = mapPackage(user);
		return map;
	}
	/**
	 * @标题: mobileUpdateLoginPwd 
	 * @描述: 用户修改密码和头像 
	 * @参数 @param mobilePhone
	 * @参数 @param loginPwd
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @throws 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月10日 下午6:39:34
	 */
	@RequestMapping("mobileUpdateLoginPwd")
	@ResponseBody
	public Object mobileUpdateLoginPwd(int id,String mobilePhone,String loginPwd,String logoUrl){
		Map<String,Object> map = new HashMap<String,Object>();
		String id_num = NumberValidationUtils.inversionNum(id);
		if (!NumberValidationUtils.isPositiveInteger(id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (id==0||mobilePhone==null||loginPwd==null||logoUrl==null||"".equals(mobilePhone)||"".equals(loginPwd)||"".equals(logoUrl)||"null".equals(mobilePhone)||"null".equals(loginPwd)||"null".equals(logoUrl)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		iUserService.mobileUpdateUser(id,mobilePhone,loginPwd,logoUrl);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: mobileUpdateLoginPwd 
	 * @描述: 更新用户支付密码
	 * @参数 @param id  用户id
	 * @参数 @param payPwd 用户支付密码
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型  返回为map
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月11日 下午2:55:40
	 */
	@RequestMapping("mobileUpdatePayPwd")
	@ResponseBody
	public Object mobileUpdateLoginPwd(int id,String payPwd){
		Map<String,Object> map = new HashMap<String,Object>();
		String id_num = NumberValidationUtils.inversionNum(id);
		if (!NumberValidationUtils.isPositiveInteger(id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (id==0||payPwd==null||"".equals(payPwd)||"null".equals(payPwd)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		iUserService.mobileUpdatePayPwd(id,payPwd);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: getVerifyCode 
	 * @描述: 登陆页面获取验证码
	 * @参数 @return    设定文件 
	 * @返回 String    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月18日 下午5:22:48
	 */
	private String getVerifyCode() {
		Integer sd = (int) ((Math.random()*9+1)*1000);
		String verifyCode = sd.toString();
		System.out.println("登录验证码是："+verifyCode);
		return verifyCode;
	}
	
}