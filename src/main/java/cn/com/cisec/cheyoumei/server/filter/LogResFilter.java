package cn.com.cisec.cheyoumei.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

import cn.com.cisec.cheyoumei.server.model.User;
/**
 * @类名: LogResFilter 
 * @描述: Web过滤器,获取登陆用户信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月17日 下午5:06:30
 */
public class LogResFilter implements Filter{
	private final static double DEFAULT_USERID=0.0;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("进入过滤器");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (session==null) {
			MDC.put("userId", DEFAULT_USERID);
		}else {
			User customer = (User) session.getAttribute("user");
			if (customer==null) {
				MDC.put("userId", DEFAULT_USERID);
				MDC.put("userName", DEFAULT_USERID);
			}else {
				MDC.put("userId", customer.getUserName());
				MDC.put("userName", customer.getUserName());
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
