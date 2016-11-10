package cn.com.cisec.cheyoumei.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.service.ICommentService;
import cn.com.cisec.cheyoumei.server.service.IGoodsService;
import cn.com.cisec.cheyoumei.server.service.IOrdersService;
import cn.com.cisec.cheyoumei.server.util.GetIpAddressUtils;
import cn.com.cisec.cheyoumei.server.util.NumberValidationUtils;
import cn.com.cisec.cheyoumei.server.util.ProjectState;
/**
 * @类名: CommentController 
 * @描述: 用户评论信息同时获取用户的IP地址
 * @作者 liuren-mail@163.com
 * @日期 2015年6月15日 下午4:29:46
 */
@Controller
public class CommentController {
	@Autowired
	private ICommentService iCommentService;
	@Autowired
	private IGoodsService iGoodsService;
	@Autowired
	private IOrdersService iOrdersService;
	/**
	 * @标题: addComment 
	 * @描述: 手机端增加评论未编写上传图片代码
	 * @参数 @param goodsId
	 * @参数 @param userId
	 * @参数 @param rasePoint
	 * @参数 @param message
	 * @参数 @param request
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @throws 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月16日 下午2:47:47
	 */
	@RequestMapping("mobile/comment")
	@ResponseBody
	public Object addComment(int goodsId,int userId,int rasePoint,String message,String orderCode,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		String goodsId_num =NumberValidationUtils.inversionNum(goodsId); 
		String userId_num =NumberValidationUtils.inversionNum(userId); 
		String rasePoint_num =NumberValidationUtils.inversionNum(rasePoint);
		String ipAddr = GetIpAddressUtils.getIpAddr(request);
		if (!NumberValidationUtils.isPositiveInteger(goodsId_num)||!NumberValidationUtils.isPositiveInteger(userId_num)||!NumberValidationUtils.isPositiveInteger(rasePoint_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (goodsId<1||userId<1||rasePoint<1) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (orderCode==null||"".equals(orderCode)) {
			iCommentService.addComment(goodsId,userId,rasePoint,message,ipAddr);
			map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
			return map;
		}
		if (orderCode==null||"".equals(orderCode)||"null".equals(orderCode)) {
			iCommentService.addComment(goodsId,userId,rasePoint,message,ipAddr);
			map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
			return map;
		}
		//增加订单评论的时候，判断订单是否评论过,如果评论过就返回失败,不允许再评论
		System.out.println("orderCode:"+orderCode);
		boolean iscomment = iOrdersService.findIscommentByOrderCode(orderCode);
		System.out.println("isComment:"+iscomment);
		if (iscomment) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
			iCommentService.addCommentVsOrderCode(goodsId,userId,rasePoint,message,ipAddr,orderCode);
			map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: findCommentList 
	 * @描述: 手机端获取评论列表 
	 * @参数 @param shopId
	 * @参数 @param currentPage
	 * @参数 @param pageSize
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月16日 下午2:46:56
	 */
	@RequestMapping("mobile/findCommentList")
	@ResponseBody
	public Object findCommentList(String shopId,Integer currentPage,Integer pageSize){
		String currentPage_num = NumberValidationUtils.inversionNum(currentPage);
		String pageSize_num = NumberValidationUtils.inversionNum(pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		if (!NumberValidationUtils.isPositiveInteger(shopId)||!NumberValidationUtils.isPositiveInteger(currentPage_num)||!NumberValidationUtils.isPositiveInteger(pageSize_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (currentPage==null||"".equals(currentPage)||pageSize==null||"".equals(pageSize)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		List<Integer> goodsList =iGoodsService.findGoods(shopId);
		if (goodsList.isEmpty()) {
			map.put("datas", null);
			return map;
		}
		int limitStart = (currentPage-1)*pageSize;
		Object commentList = iCommentService.findCommentList(goodsList,limitStart,pageSize);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map.put("datas", commentList);
		return map;
	}
}
