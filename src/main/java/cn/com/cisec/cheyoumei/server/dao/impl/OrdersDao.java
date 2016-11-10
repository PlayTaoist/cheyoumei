package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IOrdersDao;
import cn.com.cisec.cheyoumei.server.dto.OrdersListDto;
import cn.com.cisec.cheyoumei.server.model.Orders;
@Repository
public class OrdersDao extends BaseDao<Orders> implements IOrdersDao {
	private final static Logger log = Logger.getLogger(OrdersDao.class);
	@Override
	public Orders findOrdersByOrderNum(String ordersNum,int serverType) {
		return (Orders)queryObject("select o from Orders o where serverType = "+serverType+" and o.orderCode=?",ordersNum);
	}
	@Override
	public List<OrdersListDto> findOrdersByCustomerId(int customerid,int serverType) {
		String sql = "select o.id as id,o.orderCode as orderCode,o.payStatus as payStatus,"
				+ "o.tradeNum as tradeNum,o.orderStatus as orderStatus,o.fromAccount as fromAccount,"
				+ "o.accountRecv as accountRecv,o.totalRecv as totalRecv,o.serverType as serverType,o.shopName as shopName,"
				+ "o.point as point,o.couponCode as couponCode,o.discount as discount,o.totalReturn as totalReturn,"
				+ "o.payAt as payAt,o.customerConfirm as customerConfirm,o.shopConfirm as shopConfirm,"
				+ "o.createdAt as createdAt,o.scheduleAt as scheduleAt,o.servicedAt as servicedAt,"
				+ "o.updatedAt as updatedAt,o.userByUpdatedBy_id as userByUpdatedBy,o.paymentForm_id as paymentForm,"
				+ "o.address as address,o.seller_id as seller,o.customer_id as customer,o.goods_id as goods,"
				+ "o.serviceName as serviceName,o.shopGalleryUrl as shopGalleryUrl,o.iscomment as iscomment from"
				+ " Orders o where o.orderStatus>-1 and o.customer_id ="+customerid+" and o.serverType="+serverType+"";
		return findMobileDatasBySql(sql, OrdersListDto.class, 0, 0, false);
	}
	@Override
	public int findIdByOrdersNum(String orderCode) {
		String sql ="select o.id from Orders o where o.orderCode ="+orderCode+"";
		return findIdByXXXX(sql);
	}
	@Override
	public List<OrdersListDto> findOrdersListByCustomerId(int customerid) {
		String sql = "select o.id as id,o.orderCode as orderCode,o.payStatus as payStatus,"
				+ "o.tradeNum as tradeNum,o.orderStatus as orderStatus,o.fromAccount as fromAccount,"
				+ "o.accountRecv as accountRecv,o.totalRecv as totalRecv,o.serverType as serverType,o.shopName as shopName,"
				+ "o.point as point,o.couponCode as couponCode,o.discount as discount,o.totalReturn as totalReturn,"
				+ "o.payAt as payAt,o.customerConfirm as customerConfirm,o.shopConfirm as shopConfirm,"
				+ "o.createdAt as createdAt,o.scheduleAt as scheduleAt,o.servicedAt as servicedAt,"
				+ "o.updatedAt as updatedAt,o.userByUpdatedBy_id as userByUpdatedBy,o.paymentForm_id as paymentForm,"
				+ "o.address as address,o.seller_id as seller,o.customer_id as customer,o.goods_id as goods,"
				+ "o.serviceName as serviceName,o.shopGalleryUrl as shopGalleryUrl,o.iscomment as iscomment from"
				+ " Orders o where o.orderStatus>-1 and o.customer_id ="+customerid+"";
		return findMobileDatasBySql(sql, OrdersListDto.class, 0, 0, false);
	}
	@Override
	public Date findTimeByOrdersNum(String orderCode) {
		String sql ="select o.servicedAt from Orders o where o.orderCode ="+orderCode+"";
		return findTimeByXXXX(sql);
	}
	@Override
	public boolean findIscommentByOrderCode(String orderCode) {
		String sql ="select o.iscomment from Orders o where o.orderCode ="+orderCode+"";
		return findIsCommentByOrderCode(sql);
	}

}
