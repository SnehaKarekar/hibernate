package com.hibernateMapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Embeddable
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_Id")
	private int id;
	@Column(name="Book_Name")
	private String name;
	@Column(name="Book_Author")
	private String author;
	@OneToOne
	@JoinColumn(name="Person_Id")
	private People p;
	public People getP() {
		return p;
	}
	public void setP(People p) {
		this.p = p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int id, String name, String author, People p) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.p = p;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", p=" + p + "]";
	}
	
	
	
	
	
}
