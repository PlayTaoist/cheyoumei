package cn.com.cisec.cheyoumei.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.dto.GoodsCatRelDto;
import cn.com.cisec.cheyoumei.server.dto.GoodsDto;
import cn.com.cisec.cheyoumei.server.service.IShopInfoService;
import cn.com.cisec.cheyoumei.server.util.AddressSplitUtils;
import cn.com.cisec.cheyoumei.server.util.NumberValidationUtils;
import cn.com.cisec.cheyoumei.server.util.ProjectState;

/**
 * @类名: WashCarController 
 * @描述: 到店洗车控制器
 * @作者 liuren-mail@163.com
 * @日期 2015年6月5日 下午3:11:41
 */
@Controller
public class WashCarController {
	@Autowired
	private IShopInfoService iShopInfoService;
	
	/**
	 * @标题: findWashCarShopss 
	 * @描述: 上门洗车的二级菜单
	 * @参数 @param mobileAddress 手机定位的地址
	 * @参数 @param currentPage   当前为第几页
	 * @参数 @param pageSize      每页显示多少条数据
	 * @参数 @return    设定文件 
	 * @返回 Object    返回Map类型 的json数据
	 * @throws 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月8日 上午11:07:46
	 */
	@RequestMapping("arriveStore/washCar")
	@ResponseBody
	public Object findWashCarShops(String mobileAddress,Integer currentPage,Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		if (mobileAddress==null||currentPage==null||pageSize==null||"".equals(mobileAddress)||"".equals(currentPage)||"".equals(pageSize)||"null".equals(mobileAddress)||"null".equals(currentPage)||"null".equals(pageSize)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		int limitStart = (currentPage-1)*pageSize;
		// mobileAddress = "海南省海口市龙华区府城镇凤翔路321号";
		//1.根据地址信息查找整个市区的所有店铺(地址要切割)
			String[] addr = AddressSplitUtils.addrSplit(mobileAddress);
			String city = addr[1];
			Object listShopInfo = iShopInfoService.findWashCarShops(city,limitStart,pageSize); 
		//2.店铺又包括(①店铺名②星级③店铺地址信息④主打的的业务价格)
			map.put("datas", listShopInfo);
			map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: findShopDetailInfo 
	 * @描述: 详细的商店信息
	 * @参数 @param id
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月18日 上午8:47:07
	 */
	@RequestMapping("arriveStore/shopDetailInfo")
	@ResponseBody
	public Object findShopDetailInfo(Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		String id_num = NumberValidationUtils.inversionNum(id);
		if (!NumberValidationUtils.isPositiveInteger(id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (id==null||"".equals(id)||"null".equals(id)) {
			//当传入的参数为空或者没有的时候返回错误。
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		//1.根据id查询到goodsCat_id
		  Integer ids = iShopInfoService.findGoosCatId(id);
		  System.out.println("goodsCat_id==ids:"+ids);
		//2.因为googsCat_id 就是存储在child_id
		//3.根据child_id找到其对应的父parent_id和level(深度)
		  List<GoodsCatRelDto> goodsCatRel = iShopInfoService.findGoosCatRel(ids);
		  if (goodsCatRel.isEmpty()) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		  List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 for (GoodsCatRelDto gcrDto : goodsCatRel) {
			int child_id = gcrDto.getChild();
			int parent_id = gcrDto.getParent();
			int level = gcrDto.getLevel();
			//4.然后再根据parent_id查询gooscat表得到类名title
			if (level==1&&child_id!=parent_id) {
				String title = iShopInfoService.findTitleByparentId(parent_id);
				map.put("parent", title);
			}
		}
		 //然后在从Goods表中获取产品名称
		 List<GoodsDto> goodsDto = iShopInfoService.findGoodsNameById(id);
		map.put("serviceDatas", goodsDto);
		list.add(map);
		map1.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		map1.put("datas", list);
		return map1;
	}
}
