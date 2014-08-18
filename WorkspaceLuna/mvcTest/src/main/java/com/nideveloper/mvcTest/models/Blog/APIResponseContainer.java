package com.nideveloper.mvcTest.models.Blog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponseContainer {

	private int length;
	private BlogPost[] posts;
	
	public int getLength(){
		return length;
	}
	
	public void setLength(int length){
		this.length =length;
	}
	
	public BlogPost[] getPosts(){
		return posts;
	}
	
	public void setPosts(BlogPost[] posts){
		this.posts = posts;
	}
}
