package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.PhoneCode;

public interface IPhoneCodeDao extends IBaseDao<PhoneCode>{

	List<PhoneCode> findUsermobilePhone(String mobilePhone);

}
