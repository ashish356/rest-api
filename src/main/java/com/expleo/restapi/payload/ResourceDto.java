package com.expleo.restapi.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data    //Generates getter and setter 
public class ResourceDto {
	
	private long id;
	
	@NotEmpty @Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@NotEmpty @Size(min=2, message="Project should have atleast 2 characters")
	private String project;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getProject() {
		return project;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProject(String project) {
		this.project = project;
	}
;

}
