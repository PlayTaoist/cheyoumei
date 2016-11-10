package cn.com.cisec.cheyoumei.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.dao.impl.UsrCarDao;
import cn.com.cisec.cheyoumei.server.service.IUserService;
import cn.com.cisec.cheyoumei.server.service.IUsrCarService;
import cn.com.cisec.cheyoumei.server.util.NumberValidationUtils;
import cn.com.cisec.cheyoumei.server.util.ProjectState;
/**
 * @类名: UsrCarController 
 * @描述: 用户车辆管理控制器
 * @作者 liuren-mail@163.com
 * @日期 2015年6月9日 上午11:14:19
 */
@Controller
public class UsrCarController {
	@Autowired
	private IUsrCarService iUsrCarService;
	
	/**
	 * @标题: addUsrCar 
	 * @描述: 用户车辆添加方法
	 * @参数 @param plateNum 用户的车牌号
	 * @参数 @param carColor 用户车辆颜色
	 * @参数 @param userid_id 车辆所属用户的ID
	 * @参数 @param carbrand  车的型号和品牌(奥迪 A6 mylove)
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月9日 下午4:11:09
	 */
	@RequestMapping("usrCar/add")
	@ResponseBody
	public Object addUsrCar(String plateNum,String carColor,Integer userid_id,String carbrand){
		Map<String,Object> map = new HashMap<String, Object>();
		String userid_id_num = NumberValidationUtils.inversionNum(userid_id);
		if (!NumberValidationUtils.isPositiveInteger(userid_id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (plateNum==null||carColor==null||userid_id==null||carbrand==null||"".equals(plateNum)||"".equals(carColor)||"".equals(userid_id)||"".equals(carbrand)||"null".equals(plateNum)||"null".equals(userid_id)||"null".equals(carbrand)||"null".equals(carColor)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		String carBrandName = carbrand.substring(0, carbrand.indexOf(" ")); 
		//String seriesName =  carbrand.substring(carbrand.indexOf(" ")+1, carbrand.length());
		System.out.println("carBrandName:"+carBrandName);
		System.out.println("carbrand:"+carbrand);
		//获取车系列和车品牌名称
		String result = iUsrCarService.addUsrCar(plateNum,carColor,userid_id,carBrandName,carbrand);
		if (result==null||"".equals(result)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: findUsrCarList 
	 * @描述: 获取用户车库列表
	 * @参数 @param userid_id
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月10日 上午9:20:33
	 */
	@RequestMapping("usrCar/findUsrCar")
	@ResponseBody
	public Object findUsrCarList(Integer userid_id){
		Map<String,Object> map = new HashMap<String, Object>();
		String userid_id_num = NumberValidationUtils.inversionNum(userid_id);
		if (!NumberValidationUtils.isPositiveInteger(userid_id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (userid_id==null||"".equals(userid_id)||"null".equals(userid_id)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		List list = iUsrCarService.findUsrCar(userid_id);
		map.put("datas", list);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: updateUsrCarList 
	 * @描述: 修改车库信息表
	 * @参数 @param userid_id
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月10日 上午9:21:02
	 */
	@RequestMapping("usrCar/updateUsrCar")
	@ResponseBody
	public Object updateUsrCar(Integer id,String plateNum,String carColor,String carSeries){
		Map<String,Object> map = new HashMap<String, Object>();
		String id_num = NumberValidationUtils.inversionNum(id);
		if (!NumberValidationUtils.isPositiveInteger(id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (id==null||plateNum==null||carColor==null||carSeries==null||"".equals(id)||"".equals(plateNum)||"".equals(carColor)||"".equals(carSeries)||"null".equals(id)||"null".equals(plateNum)||"null".equals(carColor)||"null".equals(carSeries)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		String carBrandName = carSeries.substring(0, carSeries.indexOf(" ")); 
		iUsrCarService.updateUsrCar(id,plateNum,carColor,carSeries,carBrandName);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	/**
	 * @标题: delUsrCar 
	 * @描述: 删除车库里的车辆信息
	 * @参数 @param plateNum
	 * @参数 @param carColor
	 * @参数 @param carSeries
	 * @参数 @return    设定文件 
	 * @返回 Object    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月10日 上午9:55:35
	 */
	@RequestMapping("usrCar/delUsrCar")
	@ResponseBody
	public Object delUsrCar(Integer id){
		Map<String,Object> map = new HashMap<String, Object>();
		String id_num = NumberValidationUtils.inversionNum(id);
		if (!NumberValidationUtils.isPositiveInteger(id_num)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		if (id==null||"".equals(id)||"null".equals(id)) {
			map.put(ProjectState.STATECODE, ProjectState.FAILED);
			return map;
		}
		iUsrCarService.delUsrCar(id);
		map.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return map;
	}
	
	@RequestMapping("usrCar/defaultCar")
	@ResponseBody
	public Object defaultCar(int userid_id,int carId){
		Map<String,Object> mapResult = new HashMap<String, Object>();
		//查询用户车辆
		List<Map<String,Object>> list = iUsrCarService.findUsrCar(userid_id);
		System.out.println(list);
		for (Map<String,Object> map : list) {
			Integer Id = (Integer) map.get("id");
			System.out.println("Id:"+Id);
			iUsrCarService.modifyUsrCarInfoToFalse(Id);
		}
//		iUsrCarService.modifyUsrCarInfoToTrue(carId);
		mapResult.put(ProjectState.STATECODE, ProjectState.SUCCESS);
		return mapResult;
	}
}
