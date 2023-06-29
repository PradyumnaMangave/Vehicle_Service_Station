package com.sunbeam.entities;

import com.sunbeam.dao.Parts_DAO;

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
	
	public Serviceparts() {
		
	}
	public Part_Entity getPart() {
        // Assuming you have a PartDAO class for accessing part information
        Parts_DAO partDAO = new Parts_DAO();

        // Retrieve the part details using the partId
        Part_Entity part = partDAO.getPart(partid);

        return part;
    }
	
	@Override
	public String toString() {
		return "ServiceParts [partid=" + partid + ", quantity=" + quantity + "]";
	}
	
	
}
