package com.sunbeam.entities;

public abstract class Service {
	private int id;
	private String type;
	protected double total_cost;
	protected String remark;
	
	public Service(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public abstract void acceptService();
	
 	public abstract void calculateTotalCost();
}
