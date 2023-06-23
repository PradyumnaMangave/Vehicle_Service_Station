package com.sunbeam.DAOtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sunbeam.dao.serviceDAO;
import com.sunbeam.entities.Service;
import com.sunbeam.entities.ServiceRequestEntity;
import com.sunbeam.entities.maintainance;
import com.sunbeam.entities.oil;

public class ServiceDAOTest {
    private static ServiceRequestEntity serviceRequest;
    private static Service maintainanceService;
    private static Service oilService;

    @BeforeAll
    public static void setup() {
       
        serviceRequest = new ServiceRequestEntity();
        serviceRequest.setId(1); 
        
       
        maintainanceService = new maintainance();
        maintainanceService.setId(1);
        maintainanceService.setRemark("Sample remark");
        ((maintainance) maintainanceService).setLabourCharges(100.0);
        maintainanceService.setTotal_cost(200.0);
        
        // Create a sample oil service
        oilService = new oil();
        oilService.setId(2); // Replace with the actual ID
        oilService.setRemark("Sample remark");
        ((oil) oilService).setOil_cost(50.0);
        oilService.setTotal_cost(150.0);
    }

    @Test
    public void testGetAllServices() {
        
        List<Service> services = serviceDAO.getAllServices(serviceRequest);

        
        Assertions.assertNotNull(services);
        Assertions.assertFalse(services.isEmpty());
        System.out.println("tested");
       
    }

    @Test
    public void testCreateNewMaintainance() {
        
        serviceDAO.createNewMaintainance(serviceRequest, maintainanceService);
        System.out.println("tested");
    }

    @Test
    public void testCreateNewOilChange() {
     
        serviceDAO.createNewOilChange(serviceRequest, (oil) oilService);
        System.out.println("tested");
       
    }

    @Test
    public void testUpdateMaintainance() {
       
        serviceDAO.updateMaintainance(serviceRequest, maintainanceService);
        System.out.println("tested");

    }

    @Test
    public void testUpdateOilChange() {
       
        serviceDAO.updateOilChange(serviceRequest, (oil) oilService);
        System.out.println("tested");
    }

}
