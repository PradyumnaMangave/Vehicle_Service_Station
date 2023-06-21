package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class maintainance extends Service{

	private double labourCharges;
	private double parts_cost;
	private List<Serviceparts> partsList;

	public maintainance() {
		super("maintainance");
		this.labourCharges = 0;
		this.partsList =new ArrayList<Serviceparts>();
	}
	
	
	public double getLabourCharges() {
		return labourCharges;
	}


	public void setLabourCharges(double labourCharges) {
		this.labourCharges = labourCharges;
	}


	public double getParts_cost() {
		return parts_cost;
	}


	public void setParts_cost(double parts_cost) {
		this.parts_cost = parts_cost;
	}


	public List<Serviceparts> getPartsList() {
		return partsList;
	}


	public void setPartsList(List<Serviceparts> partsList) {
		this.partsList = partsList;
	}


	@Override
	public String toString() {
		return "maintainance [labourCharges=" + labourCharges + ", parts_cost=" + parts_cost + "]";
	}
	
	
}
