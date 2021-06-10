package com.oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Accounts")
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Account_Number")
	private int accountNum;
	@Column(name="Bank_Name")
	private String bankName;
	@ManyToOne
	@JoinColumn(name="Person_Id")
	private Person person;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String name) {
		this.bankName = name;
	}
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accounts(int accountNum, String bankName, Person person) {
		super();
		this.accountNum = accountNum;
		this.bankName = bankName;
		this.person = person;
	}
	@Override
	public String toString() {
		return "Accounts [accountNum=" + accountNum + ", bankName=" + bankName + ", person=" + person + "]";
	}
	
}
