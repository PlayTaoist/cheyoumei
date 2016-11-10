package cn.com.cisec.cheyoumei.server.dao;

import cn.com.cisec.cheyoumei.server.dto.UserListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.User;


public interface IUserDao  extends IBaseDao<User>{

	User getUserByUsername(String username);

	Pager<UserListDto> findUserList(String query);

	User findUserByMobilePhone(String mobilePhone);

}
