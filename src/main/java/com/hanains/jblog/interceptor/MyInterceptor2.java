package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor2 extends HandlerInterceptorAdapter {
	
	//MyInterceptor 2는 /user/** 의 모든 곳에 Mapping을 해놨다.
	//따로 객체를 안 받았음.
	//sysout을 통해서 내용이 확인됨.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("MyInterceptor2 PreHandle Called");
		
		return true;
		//return super.preHandle(request, response, handler);
	}
}
