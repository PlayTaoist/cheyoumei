package cn.com.cisec.cheyoumei.server.dao;

import java.util.Date;
import java.util.List;

import cn.com.cisec.cheyoumei.server.dto.OrdersListDto;
import cn.com.cisec.cheyoumei.server.model.Orders;

public interface IOrdersDao extends IBaseDao<Orders>{

	Orders findOrdersByOrderNum(String ordersNum,int serverType);

	List<OrdersListDto> findOrdersByCustomerId(int customerid,int serverType);

	int findIdByOrdersNum(String orderCode);

	List<OrdersListDto> findOrdersListByCustomerId(int customerid);

	Date findTimeByOrdersNum(String orderCode);

	boolean findIscommentByOrderCode(String orderCode);

}
