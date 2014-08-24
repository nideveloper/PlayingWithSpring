package com.nideveloper.mvcTest.models.fields;

import java.util.ArrayList;
import java.util.List;

public class RadioGroup extends Field{

	private List<Radio> radioOptions;
	
	public RadioGroup(){
		super();
		this.type = "radio";
		this.radioOptions = new ArrayList<Radio>();
		super.addCssClass("form-control");
	}
	
	public List<Radio> getRadioOptions(){
		return radioOptions;
	}
	
	public void addRadioOption(Radio option){
		this.radioOptions.add(option);
	}
	
	public void setRadioOptions(List<Radio> radioOptions){
		this.radioOptions = radioOptions;
	}
}
