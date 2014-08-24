package com.nideveloper.mvcTest.models.fields;


public class Radio extends Field{
	public Radio(){
		super();
		this.type = "radio";
		super.addCssClass("form-control");
	}
}
