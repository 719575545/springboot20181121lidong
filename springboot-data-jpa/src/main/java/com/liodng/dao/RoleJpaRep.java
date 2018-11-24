package com.liodng.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liodng.pojo.Role;

public interface RoleJpaRep extends JpaRepository<Role, Integer> {

}
