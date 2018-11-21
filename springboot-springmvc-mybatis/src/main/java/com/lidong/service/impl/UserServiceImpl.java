package com.lidong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lidong.mapper.UserMapper;
import com.lidong.pojo.User;
import com.lidong.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		this.userMapper.insertUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userMapper.getAllUser();
	}

	@Override
	public void deleteUserByid(Integer userid) {
		this.userMapper.deleteUserByid(userid);
	}

	@Override
	public User selectByid(Integer id) {
		return this.userMapper.selectByid(id);
	}

	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}
}
