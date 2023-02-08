package com.placementManagement.entity;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Corporate {
	
	@Id
	private Integer id;
	private String name;
	private String type;
	private String password;
	private Integer is_active;
	

public Integer getIsActive() {
		return is_active;
	}

	public void setIsActive(Integer isActive) {
		this.is_active = isActive;
	}

	//  Default Constructor
	public Corporate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// parameterized constructor
	public Corporate(Integer id, String name, String type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	}