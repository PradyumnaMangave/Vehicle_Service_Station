package com.sunbeam.entities;

import java.math.BigDecimal;

public class Part_Entity {
	
	private int id;
	private String name;
	private String description;
	private double price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Part_Entity(int id,String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Part_Entity(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Part_Entity(int id2, String name2) {
		super();
		this.id = id;
		this.name = name;
	}
	public Part_Entity(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Part_Entity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}
