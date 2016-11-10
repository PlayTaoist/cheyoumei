package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dao.IRoleDao;
import cn.com.cisec.cheyoumei.server.dao.IUserDao;
import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.UserListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.Role;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.model.UsrCar;
import cn.com.cisec.cheyoumei.server.service.IUserService;
@Service
public class UserService implements IUserService {
	public static final String USERTAG="user";
	private IUserDao userDao;
	private IRoleDao roleDao;
	@Autowired
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean checkUser(String username, String password,HttpSession session) {
		User user  = userDao.getUserByUsername(username);
		if(user==null){
			return false;
		}
		if(user.getLoginPwd().compareTo(password)==0){
			session.setAttribute(USERTAG, user);
			return true;
		}
		return false;
	}
	/**
	 * 用户是否登陆
	 * @param session
	 * @return
	 */
	public boolean isLogin(HttpSession session){
		User user = (User) session.getAttribute(UserService.USERTAG);
		if(user!=null){
			return true;
		}
		return false;
	}
	@Override
	public User getUser(String name) {
		return userDao.getUserByUsername(name);
	}
	@Override
	public Pager<UserListDto> findUserList(String query) {
		return userDao.findUserList(query);
	}
	/**
	 * 获得EXT中选择角色列表
	 */
	@Override
	public List<SelectListDto> getRoleListByUserId(int id) {
		
		User user  =null;
		if(id!=0) user = userDao.load(id);
		List<Role> list = roleDao.getAllRole();
		List<SelectListDto> result  = new ArrayList<SelectListDto>();
		for(Role role:list){
			boolean checked = false;
			if(user!=null&&role.getId()==user.getRole().getId()){
				checked =true;
				break;
			}
			SelectListDto sld =  new SelectListDto(role.getName(),"role", role.getId(), checked);
			result.add(sld);
		}
		return result;
	}
	@Override
	public Map<String, Object> addUser(String username, String password,
			String likename, String description, int roleId) {
		Role role  = roleDao.load(roleId);
		Map<String, Object> result = new HashMap<String, Object>();
		if(role==null){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
			result.put(ResultInfo.MSG, "角色不存在");
			return result;
		}
		User user  = new User(username, password);
		user.setRole(role);
		userDao.add(user);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "添加成功");
		return result;
	}

	@Override
	public void addUser(String mobilePhone) {
		Role role = roleDao.load(5);
		User user = new User();
		user.setMobilePhone(mobilePhone);
		user.setUserName(mobilePhone);
		user.setFirm(null);
		user.setRole(role);
		user.setPayPwd(mobilePhone);
		user.setPoint(0);
		user.setLoginPwd(mobilePhone);
		user.setLogoUrl("/images/users/logo/nologo.gif");
		user.setGender("男");
		user.setActived(true);
		user.setOnline(true);
		user.setIsdeleted(false);
		user.setTotalRase(1);
		user.setLastLogin(new Date());
		user.setCreatedAt(new Date());
		userDao.add(user);
	}
	@Override
	public User findUser(String mobilePhone) {
		return userDao.findUserByMobilePhone(mobilePhone);
	}
	@Override
	public void mobileUpdateUser(int id, String mobilePhone,
			String loginPwd, String logoUrl) {
		User user = userDao.load(id);
		user.setMobilePhone(mobilePhone);
		user.setLoginPwd(loginPwd);
		user.setLogoUrl(logoUrl);
		userDao.update(user);
	}
	@Override
	public void mobileUpdatePayPwd(int id,String payPwd) {
		User usr = userDao.load(id);
		usr.setPayPwd(payPwd);
		userDao.update(usr);
	}
	@Override
	public User findUserById(int id) {
		
		return userDao.load(id);
	}
}
