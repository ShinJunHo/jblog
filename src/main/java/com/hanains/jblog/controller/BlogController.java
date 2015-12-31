package com.hanains.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.jblog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/main")
	public String main(){
		return "/blog/blogmain";
	}
	
	@RequestMapping("/blogadmin_basic")
	public String blogadminBasic(){
		return "/blog/blogadmin_basic";
	}
}
