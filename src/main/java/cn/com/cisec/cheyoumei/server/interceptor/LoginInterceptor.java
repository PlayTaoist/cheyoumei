package cn.com.cisec.cheyoumei.server.interceptor;

import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.com.cisec.cheyoumei.server.model.Resource;
import cn.com.cisec.cheyoumei.server.model.SystemContext;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.service.IUserService;
import cn.com.cisec.cheyoumei.server.service.impl.UserService;

public class LoginInterceptor implements HandlerInterceptor {
	public static final boolean DEBUG=true;
	private IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rep,
			Object arg2) throws Exception {
		User user;
//		if(DEBUG){
//			String name  ="fcl";
//			user  = userService.getUser(name);
//			req.getSession().setAttribute(UserService.USERTAG, user);
//		}else{
			user = (User) req.getSession().getAttribute(UserService.USERTAG);
		//}
		if (user == null) {
			rep.sendRedirect(req.getContextPath() + "/index");
			return false;
		}
		String path = req.getRequestURI().replaceAll(req.getContextPath(), "");
		System.out.println(path);
		Set<Resource> resources = user.getRole().getResources();
		boolean isAuthority = false;// 是否授权
		for (Resource res : resources) {
			if (path.equals(res.getUrl())) {
				isAuthority = true;
				break;
			}
		}
		if (!isAuthority) {
			rep.setCharacterEncoding("utf-8");
			rep.setContentType("application/json;charset=UTF-8");
			PrintWriter writer = rep.getWriter();
			writer.write("{\"result\":false,\"type\":\"3\",\"msg\":\"没有访问权限\"}");
			return false;
		}
		//进行分页和排序设置
		String order  =  req.getParameter("order");
		if(order!=null&&!"".equals(order)){
			SystemContext.setOrder(order);
		}
		String sort  = req.getParameter("sort");
		if(sort!=null&&!"".equals(sort)){
			SystemContext.setSort(sort);
		}
		String start =  req.getParameter("start");
		if(start!=null&&!"".equals(start)){
			int offset  =  Integer.parseInt(start);
			SystemContext.setPageOffset(offset);
		}
		String page  = req.getParameter("page");
		String limit  = req.getParameter("limit");
		if(page!=null&&!"".equals(page)&&limit!=null&&!"".equals(limit)){
			int pageSize  = Integer.parseInt(page)*Integer.parseInt(limit);
			SystemContext.setPageSize(pageSize);
		}
		SystemContext.setRealPath(path);
		String query  = req.getParameter("query");
		if(query!=null&&!"".equals(query)){
			SystemContext.setQuery(query);
		}
		return true;
	}

}
