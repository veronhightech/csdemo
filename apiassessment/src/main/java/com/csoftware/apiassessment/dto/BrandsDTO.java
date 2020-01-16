package com.csoftware.apiassessment.dto;

import java.sql.Timestamp;

public class BrandsDTO {

	private int brandId;

	private String name;

	private boolean active;

	private Timestamp created_at;



//standard getters and setters

	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
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
		return "BrandsDTO [ brandId=" + brandId + ", name=" + name
			+ ", active=" + active + ", created_at=" + created_at
			+ "]";
	}
}