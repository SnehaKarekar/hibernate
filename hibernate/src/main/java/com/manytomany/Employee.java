package com.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@Column(name="Employee_Id")
	private int empid;
	@Column(name="Employee_Name")
	private String empname;
	@ManyToMany(mappedBy = "emp")
	private List<Projects> projects;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empid, String empname, List<Projects> projects) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", projects=" + projects + "]";
	}
}
