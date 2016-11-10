package cn.com.cisec.cheyoumei.server.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Log {
	private int id;
	/**
	 * 日志类型
	 */
	private int type;
	/**
	 * 日志级别
	 */
	private int rank;
	/**
	 * 日志内容
	 */
	private String content;
	
	/**
	 * 日志时间
	 */
	private Date time;
	
	public Log() {
		super();
	}
	
	
	public Log(int type, int rank, String content, Date time) {
		super();
		this.type = type;
		this.rank = rank;
		this.content = content;
		this.time = time;
	}


	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 日志类型
	 * @author lizd
	 *
	 */
	public class LogType{
		/**
		 * 激活
		 */
		public static final int TYPE_ACTIVITY=1;
	}
	/**
	 * 日志级别
	 * @author lizd
	 *
	 */
	public class LogRank{
		/**
		 * 普通日志
		 */
		public static final int RANK_INFO=1;
		/**
		 * 告警日志
		 */
		public static final int RANK_WARNING=2;
		/**
		 * 错误日志
		 */
		public static final int RANK_ERROR=3;
	}
}
