package com.lidong.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(message="username can't be blank")
	private String username;
	@NotBlank(message="password can't be blank")
	private String password;
	@NotBlank(message="age can't be blank")
	private Integer age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
	
}
