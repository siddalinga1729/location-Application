package com.locationweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//tells this is entity class
@Table(name="location")//if class name is not matching with table we are @table
public class Locations {//encapsulation is done here
@Id//tells we are using primary key
private int id;
private String name;
@Column(name = "code")
private String codes;//this names are need not matching with tables
private String type;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCodes() {
	return codes;
}
public void setCodes(String codes) {
	this.codes = codes;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

	
}
