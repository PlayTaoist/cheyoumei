package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.ICommentDao;
import cn.com.cisec.cheyoumei.server.dao.IGoodsDao;
import cn.com.cisec.cheyoumei.server.dao.IOrdersDao;
import cn.com.cisec.cheyoumei.server.dao.IUserDao;
import cn.com.cisec.cheyoumei.server.model.Comment;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.Orders;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.service.ICommentService;
@Service
public class CommentService implements ICommentService {
	
	@Autowired
	private ICommentDao iCommentDao;
	@Autowired
	private IGoodsDao iGoodsDao;
	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private IOrdersDao iOrdersDao;
	
	@Override
	public void addComment(int goodsId, int userId, int rasePoint,
			String message,String ipAddr) {
		Comment comment = new Comment();
		Goods goods = iGoodsDao.load(goodsId);
		User user = iUserDao.load(userId);
		comment.setCreatedAt(new Date());
		comment.setGoodsId(goods);
		comment.setUser(user);
		comment.setRasePoint(rasePoint);
		comment.setMessage(message);
		comment.setRemoteIp(ipAddr);
		iCommentDao.add(comment);
	}

	@Override
	public void addCommentVsOrderCode(int goodsId, int userId, int rasePoint,
			String message, String ipAddr, String orderCode) {
		
		int order_id = iOrdersDao.findIdByOrdersNum(orderCode);
		Orders orders = iOrdersDao.load(order_id);
		Comment comment = new Comment();
		Goods goods = iGoodsDao.load(goodsId);
		User user = iUserDao.load(userId);
		comment.setCreatedAt(new Date());
		comment.setGoodsId(goods);
		comment.setUser(user);
		comment.setOrders(orders);
		comment.setRasePoint(rasePoint);
		comment.setMessage(message);
		comment.setRemoteIp(ipAddr);
		iCommentDao.add(comment);
		orders.setIscomment(true);
		iOrdersDao.update(orders);
	}
	
	@Override
	public Object findCommentList(List<Integer> goodsList, int limitStart,
			Integer pageSize) {
		return iCommentDao.findCommentList(goodsList,limitStart,pageSize);
	}


}
