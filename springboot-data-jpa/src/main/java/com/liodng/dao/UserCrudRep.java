package com.liodng.dao;

import org.springframework.data.repository.CrudRepository;

import com.liodng.pojo.User;

public interface UserCrudRep extends CrudRepository<User, Integer> {

}
