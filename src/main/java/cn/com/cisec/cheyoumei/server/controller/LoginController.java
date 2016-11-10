package cn.com.cisec.cheyoumei.server.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.service.IUserService;
import cn.com.cisec.cheyoumei.server.service.impl.UserService;
import cn.com.cisec.cheyoumei.server.util.RandomValidateCode;

@Controller
public class LoginController {
	public static final boolean DEBUG=true;
	private static String TAG = LoginController.class.getSimpleName();
	private IUserService userService;
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	/**
	 * 登陆检查
	 * @param username
	 * @param password
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("loginCheck")
	@ResponseBody
	public Object loginCheck(HttpServletRequest request,HttpServletResponse reponse,String username,String password,String checkcode){
		Map<String, Object> result  = new HashMap<String,Object>();
		if(username==null||password==null||checkcode==null){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.MSG, "用户名或密码不能为空");
		}
		HttpSession session = request.getSession();
		String sessionCode=(String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
		if(sessionCode==null){
			try {
				reponse.sendRedirect("index");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(checkcode.compareToIgnoreCase(sessionCode)==0){
			if(userService.checkUser(username,password,session)){
				result.put(ResultInfo.RESULT, true);
			}else{
				result.put(ResultInfo.RESULT, false);
				result.put(ResultInfo.MSG, "用户名或密码不正确");
			}
		}else{
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.MSG, "输入的验证码不正确");
		}
	
		return result;
	}
	
	/**
	 * 登陆首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	@RequestMapping("/")
	public String root(){
		return "redirect:index";
	}
	
	@RequestMapping("exit")
	@ResponseBody
	public Object exit(HttpSession session){
		session.removeAttribute(UserService.USERTAG);
		Map<String, Object> result  = new HashMap<String,Object>();
		result.put(ResultInfo.RESULT, true);
		return result;
	}
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("manager/main")
	public String main(){
		return "manager/main";
	}
	/**
	 * 获取随即验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("getcode")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response){
		    response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
	        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expire", 0);
	        RandomValidateCode randomValidateCode = new RandomValidateCode();
	        try {
	            randomValidateCode.getRandcode(request, response);//输出图片方法
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
}
