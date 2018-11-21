package com.lidong.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidong.pojo.User;
/**
 * 接口泛型参数 
 * T：需要映射的实体类型
 * ID：映射实体的主键
 * @author lidong
 *
 */
public interface UserRep extends JpaRepository<User, Integer> {

}
