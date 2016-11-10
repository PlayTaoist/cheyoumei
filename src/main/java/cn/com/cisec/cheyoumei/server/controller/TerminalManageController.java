package cn.com.cisec.cheyoumei.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("manager/terminalManage")
public class TerminalManageController {
	@RequestMapping("getMenu")
	@ResponseBody
	public Object getMenu(){
		return null;
	}
}
