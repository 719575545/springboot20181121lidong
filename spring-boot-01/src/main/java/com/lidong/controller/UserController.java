package com.lidong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lidong.pojo.User;

/**
 * springboot 整合jsp
 * @author lidong
 *
 */
@Controller
public class UserController {
	@RequestMapping("/showuser")
	public String showUser(Model model) {
		List<User> userList=new ArrayList<User>();
		User user1=new User();
		user1.setUserage(11);
		user1.setUserid(1);
		user1.setUsername("zhangsan");
		User user2=new User();
		user2.setUserage(12);
		user2.setUserid(2);
		user2.setUsername("lisi");
		User user3=new User();
		user3.setUserage(13);
		user3.setUserid(2);
		user3.setUsername("wangwu");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		model.addAttribute("list",userList);
		//发送到发送到发送到
		return "userlist";
	}
	@RequestMapping("/show")
	public String show(Model model) {
		model.addAttribute("msg", "thymeleaf first");
		return "thymeleaf";
	}
}
