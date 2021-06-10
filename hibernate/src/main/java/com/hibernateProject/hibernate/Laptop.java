package com.hibernateProject.hibernate;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Laptop 
{
	@Id
	@Column(name = "Laptop_Id")
	private int laptopId;
	@Column(name = "Laptop_Name")
	private String laptopName;
	@Transient
	private double laptopPrice;
	@Lob
	private byte[] laptopImage;
	
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public double getLaptopPrice() {
		return laptopPrice;
	}
	public void setLaptopPrice(double laptopPrice) {
		this.laptopPrice = laptopPrice;
	}
	public byte[] getLaptopImage() {
		return laptopImage;
	}
	public void setLaptopImage(byte[] laptopImage) {
		this.laptopImage = laptopImage;
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(int laptopId, String laptopName, double laptopPrice, byte[] laptopImage) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
		this.laptopPrice = laptopPrice;
		this.laptopImage = laptopImage;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopPrice=" + laptopPrice
				+ ", laptopImage=" + Arrays.toString(laptopImage) + "]";
	}
	
}
