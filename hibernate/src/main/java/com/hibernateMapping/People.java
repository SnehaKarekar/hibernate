package com.hibernateMapping;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class People {
	@Id
	@Column(name="Person_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Person_Name")
	private String name;
	@Column(name="Person_Email")
	private String email;
	@OneToOne(mappedBy = "p")
	@JoinColumn(name="Book_Id")
	private Books b;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Books getB() {
		return b;
	}
	public void setB(Books b) {
		this.b = b;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int id, String name, String email, Books b) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.b = b;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", email=" + email + ", b=" + b + "]";
	}
}
