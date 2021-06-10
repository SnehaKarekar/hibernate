package com.hql1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	private int student_id;
	private String name;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int student_id, String name) {
		super();
		this.student_id = student_id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + "]";
	}
}
