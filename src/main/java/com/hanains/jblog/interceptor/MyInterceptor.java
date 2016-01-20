package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	//MyInterceptor 1는 /blog/** 의 모든 곳에 Mapping을 해놨다.
	//따로 객체를 안 받았음.
	//sysout을 통해서 내용이 확인됨.
	
	
	//preHandler는 객체를 불러오기 전에 호출
	//PostHandler와
	//afterHandler는 DAO 접근 후에 호출되는 것을 알 수 있다.
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor.PreHandler.Called");
		
		return true;

	
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor.afterHandler.Called");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor.PostHandler.Called");
	}


}
