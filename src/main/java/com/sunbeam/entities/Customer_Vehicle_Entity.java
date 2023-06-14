package com.sunbeam.entities;

public class Customer_Vehicle_Entity {
	
	 private int id;
	    private String vehicleNumber;
	    private int customerId;
	    private int vehicleId;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getVehicleNumber() {
			return vehicleNumber;
		}
		public void setVehicleNumber(String vehicleNumber) {
			this.vehicleNumber = vehicleNumber;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getVehicleId() {
			return vehicleId;
		}
		public void setVehicleId(int vehicleId) {
			this.vehicleId = vehicleId;
		}
		public Customer_Vehicle_Entity(int id, String vehicleNumber, int customerId, int vehicleId) {
			super();
			this.id = id;
			this.vehicleNumber = vehicleNumber;
			this.customerId = customerId;
			this.vehicleId = vehicleId;
		}
		@Override
		public String toString() {
			return "Customer_Vehicle_Entity [id=" + id + ", vehicleNumber=" + vehicleNumber + ", customerId="
					+ customerId + ", vehicleId=" + vehicleId + "]";
		} 
		
	
	
}
