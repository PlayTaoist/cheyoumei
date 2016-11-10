package cn.com.cisec.cheyoumei.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ZusrLogController {
	private final static Logger log = Logger.getLogger(ZusrLogController.class);
	
	@RequestMapping("")
	@ResponseBody
	public Object logList(){
		Map<String, Object> result  = new HashMap<String, Object>();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "访问成功");
		return result;
	}
}
