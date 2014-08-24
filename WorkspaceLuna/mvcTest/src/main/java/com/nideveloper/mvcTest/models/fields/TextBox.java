package com.nideveloper.mvcTest.models.fields;

public class TextBox extends Field{

	public TextBox(){
		super();
		this.type = "textbox";
		super.addCssClass("form-control");
	}
}
