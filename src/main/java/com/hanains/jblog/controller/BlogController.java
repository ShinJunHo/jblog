package com.hanains.jblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.PostVo;
import com.hanains.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	//Blog main page
	@RequestMapping("/main/{id}")
	public String main(@PathVariable("id")String id, Model model){
		BlogVo vo = blogService.getView(id);
		Map<String,Object> map = blogService.getList(id);
		model.addAttribute("vo",vo);
		model.addAttribute("map",map);
		return "/blog/blogmain";
	}
	
	@RequestMapping("/search")
	public String blogSearch(@RequestParam(value="keyword",required=true,defaultValue="")String keyword,
			@RequestParam(value="searchCondition",required=true,defaultValue="") String searchCondition,
			Model model){
		System.out.println("keyword: "+keyword);
		System.out.println("radio: "+searchCondition);
		List<BlogVo> list = blogService.getBlogList(keyword,searchCondition);
		
		model.addAttribute("keyword",keyword);
		model.addAttribute("list",list);
		
		return "/blog/bloguserlist";
	}
	
	@RequestMapping("/blogadmin_basic")
	public String blogadminBasic(){
		return "/blog/blogadmin_basic";
	}
	
	@RequestMapping("/loginform")
	public String blogLoginform(@RequestParam(value="hid", required=true, defaultValue="")String id,
			Model model){
		System.out.println("hid : "+id);
		model.addAttribute("id",id);
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
