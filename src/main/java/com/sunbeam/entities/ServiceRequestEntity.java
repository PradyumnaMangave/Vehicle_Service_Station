package com.sunbeam.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestEntity {
	private int id;
	private String vehicleNumber;
	private Date reqDate;
	private double billAmount;
	private List<Service> serviceList;
	
	{
		this.serviceList = new ArrayList<Service>();
	}
	
	public ServiceRequestEntity(int id, String vehicleNumber, Date requestDate, double billAmount) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.reqDate = requestDate;
		this.billAmount=billAmount;
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
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public List<Service> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}
	public ServiceRequestEntity(int id, String vehicleNumber,Date reqDate, double billAmount,
			List<Service> serviceList) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.reqDate = reqDate;
		this.billAmount = billAmount;
		this.serviceList = serviceList;
	}
	public ServiceRequestEntity(int id, String vehicleNumber) {
		this.id = id;
		this.vehicleNumber = vehicleNumber;
	}
	public ServiceRequestEntity() {
		this.reqDate = reqDate;
	}
	@Override
	public String toString() {
		return "ServiceRequestEntity [id=" + id + ", vehicleNumber=" + vehicleNumber + ", reqDate=" + reqDate
				+ ", billAmount=" + billAmount + "]";
	}
	
}
