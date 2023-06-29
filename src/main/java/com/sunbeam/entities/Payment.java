package com.sunbeam.entities;

import com.google.protobuf.Timestamp;

public class Payment {

	private int id;
	private int service_request_id;
	private Timestamp tx_date;
	private double paid_amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getService_request_id() {
		return service_request_id;
	}
	public void setService_request_id(int service_request_id) {
		this.service_request_id = service_request_id;
	}
	public Timestamp getTx_date() {
		return tx_date;
	}
	public void setTx_date(Timestamp tx_date) {
		this.tx_date = tx_date;
	}
	public double getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(double paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Payment(int id, int service_request_id, Timestamp tx_date, double paid_amount) {
		super();
		this.id = id;
		this.service_request_id = service_request_id;
		this.tx_date = tx_date;
		this.paid_amount = paid_amount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", service_request_id=" + service_request_id + ", tx_date=" + tx_date
				+ ", paid_amount=" + paid_amount + "]";
	}
	
	
}
