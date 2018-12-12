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
@Table(name="day")
public class Day {


@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(name="day")
private String day;

@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="day" )
private List<ClassRoutine>classRoutine=new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

public List<ClassRoutine> getClassRoutine() {
	return classRoutine;
}

public void setClassRoutine(List<ClassRoutine> classRoutine) {
	this.classRoutine = classRoutine;
}


}
