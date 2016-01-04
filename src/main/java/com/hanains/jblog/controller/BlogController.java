package com.hanains.jblog.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.vo.PostVo;
import com.hanains.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/main")
	public String main(Model model){
		
		Map<String,Object> map = blogService.getList();
		System.out.println("\nMAP: "+map);
		model.addAttribute("map",map);
		
		
		return "/blog/blogmain";
	}
	
	@RequestMapping("/blogadmin_basic")
	public String blogadminBasic(){
		return "/blog/blogadmin_basic";
	}
	
	@RequestMapping("/loginform")
	public String blogLoginform(){
		return "/blog/loginform";
	}

	@RequestMapping("/blogadmin_write")
	public String write(){
		
		
		return "/blog/blogadmin_write";
	}
	
	//새글 등록 요청
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String postInsert(HttpSession session,@ModelAttribute PostVo vo, Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		blogService.insert(vo);
		return "redirect:/blog/main";
		
	}
	@RequestMapping("/blogadmin_category")
	public String category(){
		return "/blog/blogadmin_category";
	}
	@RequestMapping("/blogadmin_detail")
	public String detatil(){
		return "/blog//blogadmin_detail";
	}
}
