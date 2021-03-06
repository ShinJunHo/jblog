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

import com.hanains.jblog.annotation.Auth;
import com.hanains.jblog.annotation.AuthUser;
import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;
import com.hanains.jblog.vo.PostVo;
import com.hanains.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	// Blog main page
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
	public String blogadminBasic(HttpSession session,Model model){
		UserVo authUser =(UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		BlogVo vo = blogService.getView(authUser.getId());
		model.addAttribute("vo",vo);
		
		return "/blog/blogadmin_basic";
	}
	
	@RequestMapping("/loginform")
	public String blogLoginform(@RequestParam(value="hid", required=true, defaultValue="")String id,
			Model model){
		System.out.println("hid : "+id);
		model.addAttribute("id",id);
		return "/blog/loginform";
	}
	
	//새글을 작성할때.
	//일반 사용자와 블로그 주인의 비교를 넣어줘야 겠다.

	
	@Auth
	@RequestMapping("/blogadmin_write")
	public String write(@AuthUser UserVo authUser,Model model){
		/*인터셉터가 처리해주니깐.*/
		System.out.println("Write Auth "+ authUser);
		//handler를 적용하기 전에는 작동을 안하였다. authUser를 잡아오지 못함.
		//AuthUserHandlerMethodArgumentResolver를 등록하니깐 AuthUser를 가져올 수 있게된다.
		BlogVo vo = blogService.getView(authUser.getId());
		List<CategoryVo> list = blogService.getCategoryById(authUser.getId());
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		
		return "/blog/blogadmin_write";
	}
	
	/*
	 * Auth 적용 전
	@RequestMapping("/blogadmin_write")
	public String write(HttpSession session,Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if( authUser == null){
			return "redirect:/blog/loginform";
		}
		BlogVo vo = blogService.getView(authUser.getId());
		List<CategoryVo> list = blogService.getCategoryById(authUser.getId());
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		return "/blog/blogadmin_write";
	}
	*/
	
	//새글 등록 요청
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String postInsert(HttpSession session,
							@ModelAttribute PostVo vo,
							Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}

		System.out.println("POST vo:: "+vo);
		blogService.insert(vo);
		return "redirect:/blog/main/"+authUser.getId();
		
	}
	//카테고리 등록 요청에서.
	@RequestMapping("/blogadmin_category")
	public String category(HttpSession session,Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		BlogVo vo = blogService.getView(authUser.getId());
		List<CategoryVo> list = blogService.getCategoryById(authUser.getId());

		model.addAttribute("vo",vo);
		model.addAttribute("list", list);
		
		
		return "/blog/blogadmin_category";
	}
	//
	@RequestMapping("/categoryAdd")
	public String categoryAdd(HttpSession session,@RequestParam("tag")String tag,@ModelAttribute CategoryVo vo){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		if(tag.equals("insert")){
			System.out.println("TAG INSERT");
			blogService.addCategory(authUser.getId(),vo);
		}else if(tag.equals("update")){
			System.out.println("TAG UPDATE"+vo);
			blogService.updateCategory(authUser.getId(),vo);
		}
		
		return "redirect:/blog/blogadmin_category";
	}
	//
	@RequestMapping("/blogadmin_detail/{no}")
	public String detatil(HttpSession session ,@PathVariable("no")Long no,Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		BlogVo vo = blogService.getView(authUser.getId());
		System.out.println("Blog Vo : "+vo);
		Map<String,Object> map = blogService.getPostByNo(no);
		model.addAttribute("vo",vo);
		model.addAttribute("map",map);
		return "/blog/blogadmin_detail";
	}
	
	//기본설정에서 title과 tag(status)를 변경.
	//
	@RequestMapping("/update")
	public String update(HttpSession session ,@ModelAttribute BlogVo vo,Model model){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		System.out.println("Controller update::"+vo);
		blogService.update(vo);
		return "redirect:/blog/blogadmin_basic";
	}
	@RequestMapping("/delete/{no}")
	public String deleteCategory(HttpSession session,@PathVariable("no")Long no){
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			return "redirect:/blog/loginform";
		}
		blogService.deleteCategory(no);
		return "redirect:/blog/blogadmin_category";
	}
}
