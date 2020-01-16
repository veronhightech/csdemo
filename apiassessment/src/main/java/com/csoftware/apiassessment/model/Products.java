package com.csoftware.apiassessment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="Products")
public class Products  implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //GenerationType.AUTO)
	private long id;
    @Column
	private String name;
    @Column
	private String description;
    @Column
	private int brand;
    @Column
	private int category;
    @Column
	private Timestamp created_at;

public Products(){}
public Products(String name, String description, int brand, int category, Timestamp created_at){
	this.name = name;
	this.description = description;
	this.brand = brand;
	this.category = category;
	this.created_at = created_at;
}

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
	@Override
	public String toString() {
		return "Products [ id=" + id + ", name=" + name
			+ ", description=" + description + ", brand=" + brand
			+ ", category=" + category + ", created_at=" + created_at
			+ "]";
	}
}