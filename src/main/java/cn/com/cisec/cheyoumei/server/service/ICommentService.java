package cn.com.cisec.cheyoumei.server.service;

import java.util.List;

public interface ICommentService {

	void addComment(int goodsId, int userId, int rasePoint, String message,String ipAddr);

	Object findCommentList(List<Integer> goodsList, int limitStart,
			Integer pageSize);

	void addCommentVsOrderCode(int goodsId, int userId, int rasePoint,
			String message, String ipAddr, String orderCode);

}
