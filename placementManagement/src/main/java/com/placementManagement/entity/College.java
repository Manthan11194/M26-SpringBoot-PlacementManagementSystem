package com.placementManagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class College {
	 	@Id	
	    private Integer college_id; 	

	    private String college_name;	 	

	    private String location;	 	

	    private Integer isActive;
	    
		@OneToMany(fetch = FetchType.EAGER,mappedBy = "college",cascade = CascadeType.ALL)
		private List<Student> studs;
	    
	    //default constructor
	    public College() {
			super();
		
	   //parameterized constructor
		}
		public College(Integer college_id, String college_name, String location) {
			super();
			this.college_id = college_id;
			this.college_name = college_name;
			this.location = location;
		}
		//getters and setters method
		public Integer getCollege_id() {
			return college_id;
		}
		public void setCollege_id(Integer college_id) {
			this.college_id = college_id;
		}
		public String getCollege_name() {
			return college_name;
		}
		public void setCollege_name(String college_name) {
			this.college_name = college_name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Integer getIsActive() {
			return isActive;
		}
		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
		}		
	
}

