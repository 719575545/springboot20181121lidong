package com.liodng.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.liodng.pojo.User;

public interface UserSpecifictionExecutorRep extends JpaSpecificationExecutor<User>,JpaRepository<User, Integer> {

}
