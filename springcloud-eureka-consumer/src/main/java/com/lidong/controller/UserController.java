package com.lidong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidong.service.UserService;
import com.lidong.user.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/users")
	public List<User> getUsers(){
		return userService.getUser();
	}

}
