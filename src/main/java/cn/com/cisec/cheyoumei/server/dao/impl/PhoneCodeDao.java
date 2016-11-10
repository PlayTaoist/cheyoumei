package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IPhoneCodeDao;
import cn.com.cisec.cheyoumei.server.model.PhoneCode;
@Repository
public class PhoneCodeDao extends BaseDao<PhoneCode> implements IPhoneCodeDao {

	
	@Override
	public List<PhoneCode> findUsermobilePhone(String mobilePhone) {
		
		return list("from PhoneCode p where p.mobliePhone=?",mobilePhone);
	}


}
