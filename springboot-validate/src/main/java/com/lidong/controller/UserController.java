package com.lidong.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lidong.pojo.User;

@Controller
public class UserController {
	/**
	 * to page
	 */
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page,@ModelAttribute("u") User user) {
		return page;
	}
	/**
	 * add user
	 */
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("u") @Valid User user,BindingResult result){
		if(result.hasErrors()) {
			return "adduser";
		}
		System.out.println(user);
		return "OK";
	}
	/**
	 * 异常处理方式一 自定义错误页面
	 * springboot 有自己的一套异常处理机制，当出现异常的时候，会自动访问/error这一路径，并搜集到异常信息，显示到页面，我们若想自定义异常页面，就需要在templates
	 * 下新写一个页面，命名为error.html,当出现异常的以后访问到的是我们自定义的页面，
	 */
	@RequestMapping("/exceone")
	public String exceone() {
		String ss=null;
		ss.length();
		return "adduser";
	}
//	/**
//	 * 异常处理方式二 exceptionhander
//	 */
//	@ExceptionHandler(value= {java.lang.NullPointerException.class})
//	public ModelAndView excetwo(Exception e) {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("error", e.toString());
//		mv.setViewName("error1");
//		return mv;
//	}
}
