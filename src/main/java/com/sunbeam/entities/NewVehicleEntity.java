package com.sunbeam.entities;

public class NewVehicleEntity {
	
	private String vehicle_number;
	private String company;
	private String model;
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public NewVehicleEntity(String vehicle_number, String company, String model) {
		super();
		this.vehicle_number = vehicle_number;
		this.company = company;
		this.model = model;
	}
	@Override
	public String toString() {
		return "NewVehicleEntity [vehicle_number=" + vehicle_number + ", company=" + company + ", model=" + model + "]";
	}
	
}
