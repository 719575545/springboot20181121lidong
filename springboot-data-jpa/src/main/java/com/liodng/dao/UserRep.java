package com.liodng.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.liodng.pojo.User;

public interface UserRep extends Repository<User, Integer> {
	public List<User> findByName(String name);
	public  List<User> findByNameAndAge(String name,Integer age);
	public List<User> findByNameLike(String name);
}
