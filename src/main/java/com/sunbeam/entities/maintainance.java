package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class maintainance extends Service{

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
		return super.toString()+"maintainance [ labourCharges=" + labourCharges + ", parts_cost=" + parts_cost + "]";
	}


	@Override
	public void acceptService() {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter remark: ");
	    String remark = scanner.nextLine();
	    setRemark(remark);
	    
	    System.out.println("Enter labour charge: ");
	    double labourCharge = scanner.nextDouble();
	    setLabourCharges(labourCharge);
	    
	}



	@Override
	public void calculateTotalCost() {
		 double totalCost = getLabourCharges() + getParts_cost();
		 setTotal_cost(totalCost);
		
	}
	
	public void acceptPart() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter remark: ");
	    String remark = scanner.nextLine();
	    setRemark(remark);
	    
	    System.out.println("Enter labour charge: ");
	    double labourCharge = scanner.nextDouble();
	    setLabourCharges(labourCharge);
	    
	}

	
	
	
	
	
}
