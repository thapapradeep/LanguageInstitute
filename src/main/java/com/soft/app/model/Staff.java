package com.soft.app.model;

import java.sql.Date;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="staff")
public class Staff {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="conatct")
	private String contact;
	
	@Column(name="added_date")
	private Date date;
	
	@Column(name="status")
	private String status;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;

	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="staff")
	private List<StaffAttendence> staffs=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="staff")
	@JsonIgnore
	private List<StaffSalaryHistory> staffSalary=new ArrayList<>();
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public List<StaffAttendence> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffAttendence> staffs) {
		this.staffs = staffs;
	}

	public List<StaffSalaryHistory> getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(List<StaffSalaryHistory> staffSalary) {
		this.staffSalary = staffSalary;
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
	
	
	

}
