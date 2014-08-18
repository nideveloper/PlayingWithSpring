package com.nideveloper.mvcTest.models.Blog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogPost {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("ID")
	private int id;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Category")
	private int category;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getCategory(){
		return category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
}
