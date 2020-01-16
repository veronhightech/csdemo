package com.csoftware.apiassessment.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchProductsDTO {

	public Integer starPage;
	public Integer recordLimit;
	public String search;
	public List<String> fields;
	
	
}