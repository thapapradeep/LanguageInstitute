package com.soft.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classRoutine")
public class ClassRoutine {
	


@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="batch_id")
private Batch batch1;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="day_id")
private Day day;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="class1_id")
private classes class1;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="class2_id")
private classes class2;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="class3_id")
private classes class3;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Batch getBatch1() {
	return batch1;
}

public void setBatch1(Batch batch1) {
	this.batch1 = batch1;
}

public Day getDay() {
	return day;
}

public void setDay(Day day) {
	this.day = day;
}

public classes getClass1() {
	return class1;
}

public void setClass1(classes class1) {
	this.class1 = class1;
}

public classes getClass2() {
	return class2;
}

public void setClass2(classes class2) {
	this.class2 = class2;
}

public classes getClass3() {
	return class3;
}

public void setClass3(classes class3) {
	this.class3 = class3;
}





}
