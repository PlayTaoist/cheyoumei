package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.IPhoneCodeDao;
import cn.com.cisec.cheyoumei.server.model.PhoneCode;
import cn.com.cisec.cheyoumei.server.service.IPhoneCodeService;
@Service
public class PhoneCodeService implements IPhoneCodeService {
	
	@Autowired
	private IPhoneCodeDao iPhoneCodeDao;
	
	@Override
	public List<PhoneCode> findUsermobilePhone(String mobilePhone) {
		List<PhoneCode> list =iPhoneCodeDao.findUsermobilePhone(mobilePhone);
		return list;
	}

	@Override
	public void addPhoneCode(PhoneCode phoneCode) {
		iPhoneCodeDao.add(phoneCode);
	}

	@Override
	public void updatePhoneCode(int id, String mobilePhone, String verifyCode,
			Date createTime, Date invalidTime) {
		PhoneCode phoneCode = iPhoneCodeDao.load(id);
		phoneCode.setMobliePhone(mobilePhone);
		phoneCode.setCode(verifyCode);
		phoneCode.setCreatedAt(createTime);
		phoneCode.setBeforeAt(invalidTime);
		iPhoneCodeDao.update(phoneCode);
	}

}
