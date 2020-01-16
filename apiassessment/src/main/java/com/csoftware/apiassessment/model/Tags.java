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
@Table(name="Tags")
public class Tags  implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //GenerationType.AUTO)
	private int tagId;
    @Column
	private String name;
    @Column
	private boolean active;
    @Column
	private Timestamp created_at;

public Tags(){}
public Tags(String name, boolean active, Timestamp created_at){
	this.name = name;
	this.active = active;
	this.created_at = created_at;
}

	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
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
		return "Tags [ tagId=" + tagId + ", name=" + name
			+ ", active=" + active + ", created_at=" + created_at
			+ "]";
	}
}