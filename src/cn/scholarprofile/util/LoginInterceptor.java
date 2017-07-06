/**
 * 
 */
package cn.scholarprofile.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月4日 上午9:49:00
 * @Description : 拦截登录信息实现权限管理,返回true则继续执行其他拦截器，返回false则过滤失败，应该返回到指定页
 * @version 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("==>>Begin to Filter session====");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		System.out.println("===??Current User==" + user);
		String curPath = request.getRequestURL().toString();
		System.out.println("===>> curpath:" + curPath);

		if (curPath.indexOf("/index") >= 0) {
			System.out.println("----->true");
			return true;
		}
		
		//暂时测试只要除了初始页面外，其他时候只要没登陆就要求登录
		if (null == user || "".equals(user)) {
			
			return true;
			/**
			 * handle session and security if you want.
			 */
//			 request.getRequestDispatcher("/views/index.jsp").forward(request,
//			 response);
//			 return false;
		}
		
		return super.preHandle(request, response, handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
	 * afterCompletion(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
