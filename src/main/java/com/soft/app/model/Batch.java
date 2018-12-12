package com.soft.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="batchId")
	private String batchId;
	
	@Column(name="name")
	private String name;
	//@Column(name="startDate")
   // private  Date startDate;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="batch" )
	private List<classes>classes=new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<classes> getClasses() {
		return classes;
	}
	public void setClasses(List<classes> classes) {
		this.classes = classes;
	}

}
