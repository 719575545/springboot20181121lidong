package com.lidong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidong.dao.UserDaoImpl;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDao;
	public void saveUser() {
		userDao.saveUser();
	}

}
