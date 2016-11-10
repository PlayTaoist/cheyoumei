package cn.com.cisec.cheyoumei.server.controller.systemmanage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
@Controller
@RequestMapping("manager/systemManage/logList")
public class LogListController {
	@RequestMapping("")
	@ResponseBody
	public Object logList(){
		Map<String, Object> result  = new HashMap<String, Object>();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "访问成功");
		return result;
	}
}
