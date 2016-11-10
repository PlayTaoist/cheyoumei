package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.IOrdersDao;
import cn.com.cisec.cheyoumei.server.dao.IPaymentFormDao;
import cn.com.cisec.cheyoumei.server.dao.IUserDao;
import cn.com.cisec.cheyoumei.server.dto.OrdersListDto;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.Orders;
import cn.com.cisec.cheyoumei.server.model.PaymentForm;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.service.IOrdersService;
import cn.com.cisec.cheyoumei.server.util.SerialNumberUtils;
@Service
public class OrdersService implements IOrdersService {
	private final static Logger log = Logger.getLogger(OrdersService.class);
	@Autowired
	private IOrdersDao iOrdersDao;
	@Autowired
	private IUserDao iuserDao;
	@Autowired
	private IPaymentFormDao iPaymentFormDao;
	@Override
	public String addOrders(User customer, User seller, Goods goods,int serverType,String shopName,String shopAddr,String goodsName,String ShopGalleryUrl) {
		Orders orders = new Orders();
		String ordersNum = SerialNumberUtils.SerialNum();
		orders.setOrderCode(ordersNum); //设置生成的订单号
		orders.setOrderStatus(0);       //订单的状态
		orders.setAccountRecv(goods.getDiscPrice()); //应付款金额
		orders.setPoint(1); //获取相应的积分
		orders.setCreatedAt(new Date());//订单创建时间
		orders.setServerType(serverType); //订单服务类型,是1.到店洗车;2.上门洗车
		orders.setShopName(shopName);
		orders.setAddress(shopAddr);
		orders.setServiceName(goodsName); //服务名称
		orders.setShopGalleryUrl(ShopGalleryUrl);//店铺封面的URL
		orders.setShopConfirm(false); //店家确认,默认为false没有确认
		orders.setCustomerConfirm(false);//商户确认,默认为false没有确认
		orders.setIscomment(false);//默认没有发表评论
		PaymentForm paymentForm =iPaymentFormDao.load(6); //设置支付方式的默认为未选择
		orders.setPaymentForm(paymentForm);
		orders.setUserByUpdatedBy(customer); //刚生成订单的的时候默认是消费者
		orders.setCustomer(customer);  //订单的客户
		orders.setSeller(seller);      //订单的商户
		orders.setGoods(goods);       //订单的物品
		iOrdersDao.add(orders);
		return ordersNum;
	}
	@Override
	public Orders findOrdersByOrderNum(String ordersNum,int serverType) {
		return iOrdersDao.findOrdersByOrderNum(ordersNum,serverType);
	}
	@Override
	public List<OrdersListDto> findOrdersByCustomerId(int customerid,int serverType) {
		return iOrdersDao.findOrdersByCustomerId(customerid,serverType);
	}
	@Override
	public int findIdByOrdersNum(String orderCode) {
		return iOrdersDao.findIdByOrdersNum(orderCode);
	}
	@Override
	public void updateOrders(int ordersid) {
		Orders orders = iOrdersDao.load(ordersid); //拿出订单信息
		orders.setUpdatedAt(new Date()); //更新时间
		orders.setServicedAt(new Date());//服务时间
		orders.setOrderStatus(7); //订单状态
		iOrdersDao.update(orders);
	}
	@Override
	public List<OrdersListDto> findOrdersListByCustomerId(int customerid) {
		return iOrdersDao.findOrdersListByCustomerId(customerid);
	}
	@Override
	public Date findTimeByOrdersNum(String orderCode) {
		return iOrdersDao.findTimeByOrdersNum(orderCode);
	}
	@Override
	public boolean findIscommentByOrderCode(String orderCode) {
		return iOrdersDao.findIscommentByOrderCode(orderCode);
	}
	@Override
	public void updateOrdersAfterPay(int orderId,int id) {
		Orders orders = iOrdersDao.load(orderId); //拿出订单信息
		orders.setOrderStatus(1); //订单状态
		PaymentForm paymentForm = iPaymentFormDao.load(id);
		orders.setPaymentForm(paymentForm);
		Date date = new Date();
		orders.setPayAt(date); //支付时间
		double acr = orders.getAccountRecv(); //应付款
		int point = (int) acr;
		orders.setPoint(point); //设置积分问题
		iOrdersDao.update(orders);
	}

}
