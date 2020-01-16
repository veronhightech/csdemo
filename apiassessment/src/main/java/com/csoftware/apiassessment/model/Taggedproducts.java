package com.csoftware.apiassessment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Taggedproducts")
public class Taggedproducts  implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //GenerationType.AUTO)
	private long taggedProdId;
    @Column
	private long product;
    @Column
	private int tag;

public Taggedproducts(){}
public Taggedproducts(long product, int tag){
	this.product = product;
	this.tag = tag;
}

	public long getTaggedProdId() {
		return taggedProdId;
	}
	public void setTaggedProdId(long taggedProdId) {
		this.taggedProdId = taggedProdId;
	}
	public long getProduct() {
		return product;
	}
	public void setProduct(long product) {
		this.product = product;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Taggedproducts [ taggedProdId=" + taggedProdId + ", product=" + product
			+ ", tag=" + tag + "]";
	}
}