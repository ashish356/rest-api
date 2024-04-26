package com.expleo.restapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="resource")
public class Resource {
	
	@Id
	@GeneratedValue
	(
			strategy=GenerationType.IDENTITY
	)
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="project",nullable=false)
	private String project;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProject() {
		return project;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProject(String project) {
		this.project = project;
	}

	
	
	

}
