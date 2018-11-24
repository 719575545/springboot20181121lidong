package com.liodng.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="manu")
public class Manu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manuid")
	private Integer manuid;
	@Column(name="manuname")
	private String manuname;
	@Column(name="manuurl")
	private String manuurl;
	@Column(name="fmanuid")
	private Integer fatherid;
	@ManyToMany
	@JoinTable(name="role_manu",joinColumns=@JoinColumn(name="manuid"),inverseJoinColumns=@JoinColumn(name="roleid"))
	private Set<Role> roles=new HashSet<Role>();
	public Integer getManuid() {
		return manuid;
	}
	public void setManuid(Integer manuid) {
		this.manuid = manuid;
	}
	public String getManuname() {
		return manuname;
	}
	public void setManuname(String manuname) {
		this.manuname = manuname;
	}
	public String getManuurl() {
		return manuurl;
	}
	public void setManuurl(String manuurl) {
		this.manuurl = manuurl;
	}
	public Integer getFatherid() {
		return fatherid;
	}
	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
