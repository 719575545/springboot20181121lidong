package com.liodng.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liodng.pojo.User;
/**
 * 接口泛型参数含义
 *      第一个：映射的实体类
 *      第二个：实体类的主键
 * @author lidong
 *
 */
public interface UserRep extends JpaRepository<User, Integer> {

}
