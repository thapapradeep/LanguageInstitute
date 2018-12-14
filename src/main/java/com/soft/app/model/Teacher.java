package com.soft.app.model;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="teachers")
public class Teacher{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="email")
	private String email;
	
	@Column(name="salary")
	private double salary;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="teacher")
	@JsonIgnore
	private List<TeacherLanguage> teacherlanguage=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="teacher")
	@JsonIgnore
	private List<classes>classes=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="teacher")
	@JsonIgnore
	private List<TeacherAttendence>teacherAttendence=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="teacher")
	@JsonIgnore
	private List<TeacherSalaryHistory> teacherSalary=new ArrayList<>();
	





	@Column(name="added_date")
	private Date date;
	
	@Column(name="status")
	private String status;
	

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}
	

	public void setStatus(String status) {
		this.status = status;
	}

	public List<classes> getClasses() {
		return classes;
	}

	public void setClasses(List<classes> classes) {
		this.classes = classes;
	}

	public List<TeacherLanguage> getTeacherlanguage() {
		return teacherlanguage;
	}

	public void setTeacherlanguage(List<TeacherLanguage> teacherlanguage) {
		this.teacherlanguage = teacherlanguage;
	}

	public List<TeacherAttendence> getTeacherAttendence() {
		return teacherAttendence;
	}

	public void setTeacherAttendence(List<TeacherAttendence> teacherAttendence) {
		this.teacherAttendence = teacherAttendence;
	}

	public List<TeacherSalaryHistory> getTeacherSalary() {
		return teacherSalary;
	}

	public void setTeacherSalary(List<TeacherSalaryHistory> teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

 
}
