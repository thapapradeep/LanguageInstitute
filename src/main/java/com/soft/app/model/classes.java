package com.soft.app.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="classes")

public class classes {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="className")
	private String className;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name="classroomNo")
	private String classroomNo;
	
	@Column(name="startTime")
	private String startTime;
	
	@Column(name="endTime")
	private String endTime;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="studentFee")
	private float studentFee;
	
	@Column(name="teacherSalary")
	private float teacherSalary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	@Column(name="added_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="classes")
	@JsonIgnore
	private List<StudentClass>studentclass=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="class1")
	@JsonIgnore
	private List<ClassRoutine>classRoutine1=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="class2")
	@JsonIgnore
	private List<ClassRoutine>classRoutine2=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="class3")
	@JsonIgnore
	private List<ClassRoutine>classRoutine3=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="classes4")
	@JsonIgnore
	private List<StudentAttendence>studentAttendence=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="classes")
	@JsonIgnore
	private List<StudentFee>studentFees=new ArrayList<>();
	
	

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getClassroomNo() {
		return classroomNo;
	}

	public void setClassroomNo(String classroomNo) {
		this.classroomNo = classroomNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(float studentFee) {
		this.studentFee = studentFee;
	}

	public float getTeacherSalary() {
		return teacherSalary;
	}

	public void setTeacherSalary(float teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<StudentClass> getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(List<StudentClass> studentclass) {
		this.studentclass = studentclass;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<ClassRoutine> getClassRoutine1() {
		return classRoutine1;
	}

	public void setClassRoutine1(List<ClassRoutine> classRoutine1) {
		this.classRoutine1 = classRoutine1;
	}

	public List<ClassRoutine> getClassRoutine2() {
		return classRoutine2;
	}

	public void setClassRoutine2(List<ClassRoutine> classRoutine2) {
		this.classRoutine2 = classRoutine2;
	}

	public List<ClassRoutine> getClassRoutine3() {
		return classRoutine3;
	}

	public void setClassRoutine3(List<ClassRoutine> classRoutine3) {
		this.classRoutine3 = classRoutine3;
	}

	public List<StudentAttendence> getStudentAttendence() {
		return studentAttendence;
	}

	public void setStudentAttendence(List<StudentAttendence> studentAttendence) {
		this.studentAttendence = studentAttendence;
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

	public List<StudentFee> getStudentFees() {
		return studentFees;
	}

	public void setStudentFees(List<StudentFee> studentFees) {
		this.studentFees = studentFees;
	}
	




	

}
