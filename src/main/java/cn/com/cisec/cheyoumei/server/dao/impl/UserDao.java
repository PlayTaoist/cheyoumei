package cn.com.cisec.cheyoumei.server.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IUserDao;
import cn.com.cisec.cheyoumei.server.dto.UserListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.User;
@Repository
public class UserDao extends BaseDao<User> implements IUserDao{

	@Override
	public User getUserByUsername(String name) {
		return (User) queryObject("select u from User u where u.userName=?", name);
	}

	@Override
	public Pager<UserListDto> findUserList(String query) {
		String sql  = "select u.id as id,u.mobilePhone as mobilePhone,u.userName as userName,u.firm as firm,u.payPwd as payPwd,u.point as point,u.balance as balance,u.loginPwd as loginPwd,u.logoUrl as logoUrl,u.gender as gender,u.addr as addr,u.totalRase as totalRase,u.raseCount as raseCount,u.actived as isActived,u.online as isOnline,u.isdeleted as isdeleted,u.lastLogin as lastLogin,u.createdAt as createdAt,u.deletedAt as deletedAt,u.deletedByUserId as deletedByUserId,r.name as role from User u left outer join Role r on u.role_id=r.id ";
		if(query!=null&&!"".equals(query)){
			sql=sql+"where u.likename like '%"+query+"%' or u.description like '%"+query+"%' ";
		}
		return findBySql(sql, UserListDto.class, false);
	}

	@Override
	public User findUserByMobilePhone(String mobilePhone) {
		return (User) queryObject("select u from User u where u.mobilePhone=?", mobilePhone);
	}

}
