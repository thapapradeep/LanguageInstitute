package com.soft.app.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="batch" )
	private List<classes>classes=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="batch1" )
	private List<ClassRoutine>classRoutine=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="batch" )
	private List<Student>student=new ArrayList<>();
	
	@Column(name="added_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="status")
	private String status;
	
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
	public List<ClassRoutine> getClassRoutine() {
		return classRoutine;
	}
	public void setClassRoutine(List<ClassRoutine> classRoutine) {
		this.classRoutine = classRoutine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}
