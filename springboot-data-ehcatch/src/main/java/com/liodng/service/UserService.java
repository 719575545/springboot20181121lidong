package com.liodng.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.liodng.pojo.User;

public interface UserService {
	List<User> findAll();
	User findByid(Integer id);
	Page<User> findByPage(Pageable pageable);
	void saveUser(User user);
}
