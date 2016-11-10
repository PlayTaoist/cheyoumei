package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.UsrCar;

public interface IUsrCarDao extends IBaseDao<UsrCar>{

	List findUsrCar(Integer userid_id);

}
