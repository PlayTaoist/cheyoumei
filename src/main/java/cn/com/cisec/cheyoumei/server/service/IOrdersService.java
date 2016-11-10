package cn.com.cisec.cheyoumei.server.service;

import java.util.Date;
import java.util.List;

import cn.com.cisec.cheyoumei.server.dto.OrdersListDto;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.Orders;
import cn.com.cisec.cheyoumei.server.model.User;

public interface IOrdersService {

	String addOrders(User customer, User seller, Goods goods,int serverType,String shopName,String shopAddr,String goodsName,String ShopGalleryUrl);

	Orders findOrdersByOrderNum(String ordersNum,int serverType);

	List<OrdersListDto> findOrdersByCustomerId(int customerid,int serverType);

	int findIdByOrdersNum(String orderCode);

	List<OrdersListDto> findOrdersListByCustomerId(int customerid);

	void updateOrders(int ordersid);

	Date findTimeByOrdersNum(String orderCode);

	boolean findIscommentByOrderCode(String orderCode);

	void updateOrdersAfterPay(int orderId,int id);

}
