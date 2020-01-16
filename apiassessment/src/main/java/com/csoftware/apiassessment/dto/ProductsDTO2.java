package com.csoftware.apiassessment.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductsDTO2 {

	private long id;

	private String name;

	private String description;

	private int brand;

	
	private int category;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp created_at;
	
	private String [] tags;



//standard getters and setters

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public int getBrand() {
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
	}
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