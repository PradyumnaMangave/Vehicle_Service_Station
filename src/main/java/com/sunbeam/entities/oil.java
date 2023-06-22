	package com.sunbeam.entities;

import java.util.Scanner;

public class oil extends Service{

	private double oil_cost;

	public double getOil_cost() {
		return oil_cost;
	}

	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
	}

	public oil() {
		super("oil");
		this.oil_cost = 0;
	}
	

	@Override
	public String toString() {
		return "oil [oil_cost=" + oil_cost + "]";
	}

	@Override
	public void acceptService() {
		Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter remark: ");
	    String remark = scanner.nextLine();
	    setRemark(remark);
	    
	    System.out.println("Enter Oil Cost");
	    double oilCost = scanner.nextDouble();
	    setOil_cost(oilCost);
	    	
	}

	@Override
	public void calculateTotalCost() {
		double totalCost = getOil_cost() ;
		 setTotal_cost(totalCost);	
	}
	
	
}
