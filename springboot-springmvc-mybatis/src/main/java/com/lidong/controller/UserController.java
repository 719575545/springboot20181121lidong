package com.lidong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lidong.pojo.User;
import com.lidong.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String  showPage(@PathVariable String page) {
		return page;
	}
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		this.userService.addUser(user);
		return "ok";
	}
	/**
	 * 查询所有用户
	 */
	@RequestMapping("/Users")
	public String getAllUser(Model model){
		List<User> users=this.userService.getAllUser();
		model.addAttribute("users", users);
		return "userlist";
	}
	@RequestMapping("/delete")
	public String delelteuser(Integer id) {
		this.userService.deleteUserByid(id);
		return "redirect:/user/Users";
	}
	@RequestMapping("selectUserByid")
	public String selectByid(Integer id,Model model) {
		User user=this.userService.selectByid(id);
		model.addAttribute("user", user);
		return "update";
	}
	@RequestMapping("/updateuser")
	public String updateUser(User user) {
		this.userService.updateUser(user);
		return "redirect:/user/Users";
	}
}
