package com.soft.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="students")

public class Student {
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
	
	@Column(name="addedDate" , nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedDate;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="student")
	@JsonIgnore
	private List<StudentAttendence>studentAttendence=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="student")
	@JsonIgnore
	private List<StudentClass>studentclass=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="student")
	@JsonIgnore
	private List<StudentClass>studentFee=new ArrayList<>();
	
	
	

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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="batch_id")
	private Batch batch;

	public List<StudentAttendence> getStudentAttendence() {
		return studentAttendence;
	}

	public void setStudentAttendence(List<StudentAttendence> studentAttendence) {
		this.studentAttendence = studentAttendence;
	}

	public List<StudentClass> getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(List<StudentClass> studentclass) {
		this.studentclass = studentclass;
	}

	public List<StudentClass> getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(List<StudentClass> studentFee) {
		this.studentFee = studentFee;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}


	
	
	

}
