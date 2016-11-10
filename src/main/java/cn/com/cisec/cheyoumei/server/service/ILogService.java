package cn.com.cisec.cheyoumei.server.service;

import cn.com.cisec.cheyoumei.server.dao.IBaseDao;
import cn.com.cisec.cheyoumei.server.model.Log;

public interface ILogService {

	void writeLog(int type, int rank, String content);
	void writeWarningLog(int type, String content);
	void writeErrorLog(int type,String content);
	void writeInfoLog(int type,String content);
}
