package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanains.jblog.service.UserService;
import com.hanains.jblog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("AuthLoginInterceptor");
		
		String id= request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		
		vo.setId(id);
		vo.setPassword(password);
		
		
		//여기서 request.getServletContext()는 뭐지 ??
		ApplicationContext applicationContext 
		= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		
		UserService userService = applicationContext.getBean(UserService.class);
		UserVo authUser = userService.login(vo);
		
		System.out.println("AuthLoginInterceptor ++ auth:: "+authUser);
		
		if(authUser == null){
			response.sendRedirect(request.getContextPath()+"/user/login");

			return false;
		}
		//"redirect:/blog/main/"+hid;
		//로그인 성공인 경우
		//Session 만들기.
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser",authUser);
		System.out.println("request:"+request.getContextPath());
		if(vo.getId().equals("admin")){
			response.sendRedirect(request.getContextPath());
		}else{
			response.sendRedirect(request.getContextPath()+"/blog/main/"+vo.getId());
		}
		return false;
		
		
		//return super.preHandle(request, response, handler);
	}
	
}
