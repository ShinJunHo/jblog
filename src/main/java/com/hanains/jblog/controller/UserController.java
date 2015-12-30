package com.hanains.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.jblog.service.UserService;
import com.hanains.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(){
		System.out.println("Hello World");
		return "/user/login";
	}
	
	@RequestMapping("/loginsuccess")
	public String loginSuccess(HttpSession session, @ModelAttribute UserVo vo){
		System.out.println("User : "+vo);
		
		UserVo authUser = userService.login(vo);
		System.out.println("authUser : "+authUser);
		session.setAttribute("authUser", authUser);
		return "redirect:/";
	}
	
	@RequestMapping("/userRegisterForm")
	public String registerForm(){
		return "/user/userRegisterForm";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute UserVo vo){
		userService.join(vo);
		return "redirect:/";
	}
	@RequestMapping("/userlist")
	public String userList(Model model){
		
		List<UserVo> list = userService.getList();
		model.addAttribute("list",list);
		
		return "/user/userlist";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
		
	}
	
}
