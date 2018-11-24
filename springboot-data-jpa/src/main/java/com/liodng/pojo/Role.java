package com.liodng.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	@Column(name="rolename")
	private String rolename;
	@OneToMany(mappedBy="role")
	private Set<User> users =new HashSet<>();
	@ManyToMany(mappedBy="roles",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Set<Manu> Manus=new HashSet<Manu>();
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Manu> getManus() {
		return Manus;
	}
	public void setManus(Set<Manu> manus) {
		Manus = manus;
	}
	
	
}
