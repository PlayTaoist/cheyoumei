package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.Role;


public interface IRoleDao  extends IBaseDao<Role>{

	List<Role> getAllRole();

	Role getRoleByName(String name);
}
