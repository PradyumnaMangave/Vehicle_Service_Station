	package com.sunbeam.entities;

public abstract class oil extends Service{

	private double oil_cost;

	public double getOil_cost() {
		return oil_cost;
	}

	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
	}

	public oil(double oil_cost) {
		super("oil");
		this.oil_cost = oil_cost;
	}

	@Override
	public String toString() {
		return "oil [oil_cost=" + oil_cost + "]";
	}
	
	
}
