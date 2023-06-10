package com.sunbeam.entities;

import java.math.BigDecimal;

public class Part_Entity {
	
	private int id;
	private String name;
	private BigDecimal price;
	private String description;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Part_Entity(int id, String name, String description, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	@Override
	public String toString() {
		return "PartsInfo [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
}
