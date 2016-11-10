package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IRoleDao;
import cn.com.cisec.cheyoumei.server.dto.RoleListDto;
import cn.com.cisec.cheyoumei.server.model.Role;
@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public List<Role> getAllRole() {
		return list("from Role");
	}

	@Override
	public Role getRoleByName(String name) {
		return (Role) queryObject("from Role r where r.name=?", name);
	}

}
