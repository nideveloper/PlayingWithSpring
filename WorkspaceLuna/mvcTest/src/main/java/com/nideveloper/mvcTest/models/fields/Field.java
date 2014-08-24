package com.nideveloper.mvcTest.models.fields;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;


public class Field {
	protected String name;
	protected String id;
	protected String type;
	protected Boolean disabled;
	protected Boolean required;
	protected String value;
	protected Set<String> cssClasses;
	protected String label;
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	public Boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
		if(required){
			this.cssClasses.add("required");
		}else{
			this.cssClasses.remove("required");
		}
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public void setCssClasses(Set<String> cssClasses){
		this.cssClasses = cssClasses;
	}
	
	public void addCssClass(String cssClass){
		this.cssClasses.add(cssClass);
	}
	
	public String getCssClasses(){
		return StringUtils.join(cssClasses, ' ');
	}
	
	public Set<String> getCssClassesSet(){
		return cssClasses;
	}
	
	public String getLabel(){
		return label;
	}
	
	public void setLabel(String label){
		this.label = label;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Field(){
		type = "";
		disabled = false;
		required = true;
		value = "";
		cssClasses=new HashSet<String>(0);
		label = "";
		name = "";
		id = "";
	}
}
