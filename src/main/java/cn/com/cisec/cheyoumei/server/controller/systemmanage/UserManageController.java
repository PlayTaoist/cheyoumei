package cn.com.cisec.cheyoumei.server.controller.systemmanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.UserListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.service.IPhoneCodeService;
import cn.com.cisec.cheyoumei.server.service.IUserService;
@Controller
@RequestMapping("manager/systemManage/userManage")
public class UserManageController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IPhoneCodeService iPhoneCodeService;

	@RequestMapping("")
	@ResponseBody
	public Object userManage(){
		
		Map<String, Object> result  = new HashMap<String, Object>();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "访问成功");
		return result;
	}
	
	@RequestMapping("getUserList")
	@ResponseBody
	public Object getUserList(String query){
		Pager<UserListDto> page= userService.findUserList(query);//分页对象
		return page;
	}
	@RequestMapping("getRoleListByUserId")
	@ResponseBody
	public Object getRoleListByUserId(int id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<SelectListDto> resources = userService.getRoleListByUserId(id);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.LIST, resources);
		return result;
	}
	@RequestMapping("addUser")
	@ResponseBody
	public Object addUser(String username,String password,String likename,String description,int roleId){
		Map<String, Object> result = new HashMap<String, Object>();
		if(username==null||password==null||likename==null||"".equals(username)||"".equals(password)||"".equals(likename)){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
			result.put(ResultInfo.MSG, "用户/登陆名/密码不能为空");
			return result;
		}
		//result=userService.addUser(username,password,likename,description,sex,department,phone,roleId);
		result = userService.addUser(username,password,likename,description,roleId);
		return result;
	}

}
