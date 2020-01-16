package com.csoftware.apiassessment.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductsDTO {

	private String id; //long

	private String name;

	private String description;

	private String brand; //int

	
	private String category;  //int

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp created_at;
	
	private String [] tags;



//standard getters and setters

	public String getId() { 
		return id;
	}
	public void setId(String id) {  //long
		this.id = id;
	}
	
	/*
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) { //int
		this.brand = ""+brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {  //int
		this.category = ""+category;
	}
	
	/*public int getBrand() {
		return brand;
	}
	public void setBrand(int brand) {
		this.brand = brand;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}*/
	
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	 
	
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	
	
	@Override
	public String toString() {
		return "ProductsDTO [ id=" + id + ", name=" + name
			+ ", description=" + description + ", brand=" + brand
			+ ", category=" + category + ", created_at=" + created_at
			+ "]";
	}
}