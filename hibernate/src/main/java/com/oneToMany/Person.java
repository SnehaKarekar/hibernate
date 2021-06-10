package com.oneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Person_Id")
	private int id;
	@Column(name = "Person_Name")
	private String name;
	
	@OneToMany(mappedBy = "person")
	private List<Accounts> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, List<Accounts> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}

	
}
