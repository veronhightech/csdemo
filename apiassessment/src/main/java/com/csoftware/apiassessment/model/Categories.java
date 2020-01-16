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
@Table(name="Categories")
public class Categories  implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //GenerationType.AUTO)
	private int categoryId;
    @Column
	private String name;
    @Column
	private boolean active;
    @Column
	private Timestamp created_at;

public Categories(){}
public Categories(String name, boolean active, Timestamp created_at){
	this.name = name;
	this.active = active;
	this.created_at = created_at;
}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "Categories [ categoryId=" + categoryId + ", name=" + name
			+ ", active=" + active + ", created_at=" + created_at
			+ "]";
	}
}