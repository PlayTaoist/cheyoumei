package cn.com.cisec.cheyoumei.server.service;

import java.util.Date;
import java.util.List;

import cn.com.cisec.cheyoumei.server.model.PhoneCode;

public interface IPhoneCodeService {

	List<PhoneCode> findUsermobilePhone(String mobilePhone);

	void addPhoneCode(PhoneCode phoneCode);

	void updatePhoneCode(int id, String mobilePhone, String verifyCode,
			Date createTime, Date invalidTime);

}
