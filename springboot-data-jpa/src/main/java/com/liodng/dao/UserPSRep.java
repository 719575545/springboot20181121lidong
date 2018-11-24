package com.liodng.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.liodng.pojo.User;

public interface UserPSRep extends PagingAndSortingRepository<User, Integer> {

}
