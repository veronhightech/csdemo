package com.csoftware.apiassessment.dto;


public class TaggedproductsDTO {

	private long taggedProdId;

	private long product;

	private int tag;



//standard getters and setters

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
		return "TaggedproductsDTO [ taggedProdId=" + taggedProdId + ", product=" + product
			+ ", tag=" + tag + "]";
	}
}