package com.forest.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forest_admin1")
public class Admin {
	@Id
	@GeneratedValue
	private Integer id;
	private String adminName;
	private String adminPassword;
	
	public Admin() {
		super();
	}

	public Admin(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	public Admin(Integer id, String adminName, String adminPassword) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
}
