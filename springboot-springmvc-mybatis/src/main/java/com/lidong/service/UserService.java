package com.lidong.service;

import java.util.List;

import com.lidong.pojo.User;

public interface UserService {
	void addUser(User user);
	public List<User> getAllUser();
	void deleteUserByid(Integer userid);
	User selectByid(Integer id);
	void updateUser(User user);
}
