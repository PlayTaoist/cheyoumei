package cn.com.cisec.cheyoumei.server.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.dto.OrdersListDto;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.Orders;
import cn.com.cisec.cheyoumei.server.model.ShopInfo;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.service.IGoodsService;
import cn.com.cisec.cheyoumei.server.service.IOrdersService;
import cn.com.cisec.cheyoumei.server.service.IShopGalleryService;
import cn.com.cisec.cheyoumei.server.service.IUserService;
import cn.com.cisec.cheyoumei.server.util.NumberValidationUtils;
import cn.com.cisec.cheyoumei.server.util.ProjectState;

/**
 * @类名: OrdersController 
 * @描述: 订单的控制器 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月9日 上午8:29:24
 */
@Controller
public class OrdersController {
	private final static Logger log = Logger.getLogger(OrdersController.class);
	@Autowired
	private IOrdersService iOrdersService;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IGoodsService isGoodsService;
	@Autowired
	private IShopGalleryService iShopGalleryService;
	/**
	 * @标题: addOrders 
	 * @描述: 自动生成增加订单 
	 * @参数 @param customerId
	 * @参数 @param goodId
	 * @参数 @param sellerId
	 * @参数 @return    设定文件 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月15日 上午8:42:09
	 */
	@RequestMapping("addOrders")
	@ResponseBody
	public Object addOrders(int customerId,int goodId,int sellerId,int serverType){
		Map<String,Object> map = new HashMap<String,Object>();
		String customerId_num = NumberValidationUtils.inversionNum(customerId);
		String goodId_num = NumberValidationUtils.inversionNum(goodId);
		String sellerId_num = NumberValidationUtils.inversionNum(sellerId);
		if (!NumberValidationUtils.isPositiveInteger(customerId_num)||!NumberValidationUtils.isPositiveInteger(goodId_num)||!NumberValidationUtils.isPositiveInteger(sellerId_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (customerId<1||goodId<1||sellerId<1||serverType<0) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		User customer = iUserService.findUserById(customerId);
		User seller = iUserService.findUserById(sellerId);
		Goods goods = isGoodsService.findGoodsById(goodId);
		ShopInfo shopInfo = goods.getShopInfo();
		String goodsName = goods.getName();
		String shopName = shopInfo.getShopName();
		String shopAddr = shopInfo.getAddr();
		int  shopInfo_id = shopInfo.getId();
		String ShopGalleryUrl = iShopGalleryService.findShopGalleryUrl(shopInfo_id);
		String ordersNum =ProduceOrders(customer,seller,goods,serverType,shopName,shopAddr,goodsName,ShopGalleryUrl);
		//获取新生成的订单号
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map.put("datas", ordersNum);
		return map;
	}
	/**
	 * @标题: findOrders 
	 * @描述: 手机端把订单号拿回,然后返回给服务器,服务器再把数据返回给用户
	 * @参数 @param ordersNum
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月15日 上午8:43:08
	 */
	@RequestMapping("findOrders")
	@ResponseBody
	public Object findOrders(String ordersNum,int serverType){
		Map<String,Object> map = new HashMap<String,Object>();
		if (ordersNum==null||"".equals(ordersNum)||serverType<0) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		Orders orderList =iOrdersService.findOrdersByOrderNum(ordersNum,serverType);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map.put("data", orderList);
		return map;
	}
	
	/**
	 * @标题: ProduceOrders 
	 * @描述: 自动生成订单号,并返回
	 * @参数 @param customer
	 * @参数 @param seller
	 * @参数 @param goods
	 * @参数 @return    设定文件 
	 * @返回 String    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月15日 上午8:44:15
	 */
	private String ProduceOrders(User customer, User seller, Goods goods,int serverType,String shopName,String shopAddr,String goodsName,String ShopGalleryUrl) {
		return iOrdersService.addOrders(customer,seller,goods,serverType,shopName,shopAddr,goodsName,ShopGalleryUrl);
	}
	/**
	 * @标题: findOrdersByCustomerId 
	 * @描述: 根据用户id和服务类型查询订单记录
	 * @参数 @param customerid
	 * @参数 @param serverType
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月15日 下午2:30:20
	 */
	@RequestMapping("findOrdersByCustomerId")
	@ResponseBody
	public Object findOrdersByCustomerId(int customerid,int serverType){
		Map<String,Object> map = new HashMap<String,Object>();
		String customerid_num = NumberValidationUtils.inversionNum(customerid);
		if (!NumberValidationUtils.isPositiveInteger(customerid_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (customerid<1||serverType<0) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		List<OrdersListDto> list = iOrdersService.findOrdersByCustomerId(customerid,serverType);
		map.put("datas", list);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	
	/**
	 * @标题: findOrdersListByCustomerId 
	 * @描述: 根据用户id查询用户洗车记录
	 * @参数 @param customerid
	 * @参数 @param serverType
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月15日 下午2:30:20
	 */
	@RequestMapping("findOrdersListByCustomerId")
	@ResponseBody
	public Object findOrdersListByCustomerId(int customerid){
		Map<String,Object> map = new HashMap<String,Object>();
		String customerid_num = NumberValidationUtils.inversionNum(customerid);
		if (!NumberValidationUtils.isPositiveInteger(customerid_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (customerid<1) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		List<OrdersListDto> list = iOrdersService.findOrdersListByCustomerId(customerid);
		map.put("datas", list);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	
	/**
	 * @标题: confirmOrders 
	 * @描述: 服务确认返回服务时间 
	 * @参数 @param orderCode
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月18日 下午6:40:01
	 */
	@RequestMapping("mobile/confirmService")
	@ResponseBody
	public Object confirmService(String orderCode){//预约时间,更新时间
		Map<String,Object> map = new HashMap<String,Object>();
		if (orderCode==null||"".equals(orderCode)||"null".equals(orderCode)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		int ordersid = iOrdersService.findIdByOrdersNum(orderCode);
		//更新数据
		iOrdersService.updateOrders(ordersid);
		Date serviceTime =iOrdersService.findTimeByOrdersNum(orderCode);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map.put("serviceTime", serviceTime);
		return map;
	}
	/**
	 * @标题: confirmPay 
	 * @描述: 确认订单,返回状态
	 * @参数 @param orderCode
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月25日 下午4:28:18
	 */
	@RequestMapping("mobile/confirmPay")
	@ResponseBody
	public Object confirmPay(String orderCode,int id){
		Map<String,Object> map = new HashMap<String,Object>();
		if (orderCode==null||"".equals(orderCode)||"null".equals(orderCode)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		int orderId = iOrdersService.findIdByOrdersNum(orderCode);
		iOrdersService.updateOrdersAfterPay(orderId,id);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
}
