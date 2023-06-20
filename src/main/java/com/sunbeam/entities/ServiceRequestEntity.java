package com.sunbeam.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestEntity {
	private int id;
	private String vehicleNumber;
	private LocalDate reqDate;
	private double billAmount;
	private List<ServiceEntity> serviceList;
	
	{
		this.serviceList = new ArrayList<ServiceEntity>();
	}
	
	public ServiceRequestEntity(int id, String vehicleNumber) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
	}
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
	public LocalDate getReqDate() {
		return reqDate;
	}
	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public List<ServiceEntity> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<ServiceEntity> serviceList) {
		this.serviceList = serviceList;
	}
	public ServiceRequestEntity(int id, String vehicleNumber, LocalDate reqDate, double billAmount,
			List<ServiceEntity> serviceList) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.reqDate = reqDate;
		this.billAmount = billAmount;
		this.serviceList = serviceList;
	}
	@Override
	public String toString() {
		return "ServiceRequestEntity [id=" + id + ", vehicleNumber=" + vehicleNumber + ", reqDate=" + reqDate
				+ ", billAmount=" + billAmount + ", serviceList=" + serviceList + "]";
	}
	
}
