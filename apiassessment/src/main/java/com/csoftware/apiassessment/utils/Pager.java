package com.csoftware.apiassessment.utils;

public class Pager {
	public long offset=1;
	public long limit=1;
	public long num_pages=1;
	public long page=1; 
	public Pager() {
		
	}
	public void getPagerData(long totalFoundRows, int num_pagesx, int limit, int page){
	    /*** the number of pages ***/
	    this.num_pages = (long)Math.ceil((double)totalFoundRows / limit);
	    //this.num_pages = (long)Math.ceil((double)num_pages / limit);
	    if(page <=this.num_pages) {
	    	this.page = Math.max(page, 1);
	    }else {
	    	this.page = Math.max(this.num_pages, 1);
	    }
	    //this.page = Math.min(page, num_pages);
	    /*** calculate the offset ***/
	    this.offset = (this.page - 1) * limit;
	    //this.offset = (page - 1) * limit;
	    /*** a new instance of stdClass ***/
	    this.limit    = limit;
	    
	    
	   // return this;
	}
}
