package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.ILogDao;
import cn.com.cisec.cheyoumei.server.model.Log;
import cn.com.cisec.cheyoumei.server.service.ILogService;
@Service
public class LogService  implements ILogService {
	private ILogDao logDao;
	@Autowired
	public void setLogDao(ILogDao logDao) {
		this.logDao = logDao;
	}


	@Override
	public void writeLog(int type, int rank, String content) {
		Log log  = new Log(type, rank, content,new Date());
		System.out.println(content);
		logDao.add(log);
	}

	@Override
	public void writeWarningLog(int type, String content) {
		writeLog(type, Log.LogRank.RANK_WARNING, content);
	}

	@Override
	public void writeErrorLog(int type, String content) {
		writeLog(type, Log.LogRank.RANK_ERROR, content);
	}

	@Override
	public void writeInfoLog(int type, String content) {
		writeLog(type, Log.LogRank.RANK_INFO, content);
	}



}
