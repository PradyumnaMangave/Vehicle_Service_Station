package com.sunbeam.entities;

public class Serviceparts {

	private int partid;
	private int quantity;
	public int getPartid() {
		return partid;
	}
	public void setPartid(int partid) {
		this.partid = partid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Serviceparts(int partid, int quantity) {
		super();
		this.partid = partid;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ServiceParts [partid=" + partid + ", quantity=" + quantity + "]";
	}
	
	
}
