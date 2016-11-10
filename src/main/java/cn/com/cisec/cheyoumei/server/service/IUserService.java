package cn.com.cisec.cheyoumei.server.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.UserListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.User;

public interface IUserService {

	boolean checkUser(String username, String password, HttpSession session);
	public boolean isLogin(HttpSession session);
	User getUser(String name);
	Pager<UserListDto> findUserList(String query);
	List<SelectListDto> getRoleListByUserId(int id);
	Map<String, Object> addUser(String username, String password,
			String likename, String description, int roleId);
	void addUser(String mobilePhone);
	User findUser(String mobilePhone);
	void mobileUpdateUser(int id, String mobilePhone, String loginPwd,
			String logoUrl);
	void mobileUpdatePayPwd(int id,String payPwd);
	User findUserById(int id);
	
}
