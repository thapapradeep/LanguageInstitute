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
@Table(name="language")
public class Language {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="language", nullable=false)
	private String language;
	
	@Column(name="added_date")
	private Date date;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="language")
	@JsonIgnore
	private List<TeacherLanguage> teacherlanguages=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="language")
	@JsonIgnore
	private List<classes>clas=new ArrayList<>();
	
	
	public List<classes> getClas() {
		return clas;
	}

	public void setClas(List<classes> clas) {
		this.clas = clas;
	}

	public long getId() {
		return id;
	}

	public List<TeacherLanguage> getTeacherlanguages() {
		return teacherlanguages;
	}

	public void setTeacherlanguages(List<TeacherLanguage> teacherlanguages) {
		this.teacherlanguages = teacherlanguages;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
