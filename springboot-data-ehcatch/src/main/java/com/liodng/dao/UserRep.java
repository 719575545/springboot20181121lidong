package com.liodng.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.liodng.pojo.User;

public interface UserRep extends JpaRepository<User, Integer> {
	
}
