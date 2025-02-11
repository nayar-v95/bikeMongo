package com.bikemongo.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Bike {
	@Id
	private String  id;
	private String buyerName;
	private String email;
	private Number phone ;
	private String model;
	private String serialNumber;
	private int price;
	private Date purchaseDate;
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBuyerName() {
		return buyerName;
	}



	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Number getPhone() {
		return phone;
	}



	public void setPhone(Number phone) {
		this.phone = phone;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getSerialNumber() {
		return serialNumber;
	}



	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public Date getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	@Override
	public String toString() {
		return "Bike [buyerName=" + buyerName + ", email=" + email + ", phone=" + phone + ", model=" + model
				+ ", serialNumber=" + serialNumber + ", price=" + price + ", purchaseDate=" + purchaseDate + "]";
	}
	
}
