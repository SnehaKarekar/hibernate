package com.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects {
	@Id
	@Column(name="Project_Id")
	private int projid;
	@Column(name="Project_Name")
	private String projname;
	@ManyToMany
	private List<Employee> emp;
	public int getProjid() {
		return projid;
	}
	public void setProjid(int projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projects(int projid, String projname, List<Employee> emp) {
		super();
		this.projid = projid;
		this.projname = projname;
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Projects [projid=" + projid + ", projname=" + projname + ", emp=" + emp + "]";
	}
}
