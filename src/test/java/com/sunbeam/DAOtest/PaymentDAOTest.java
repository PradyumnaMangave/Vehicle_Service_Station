package com.sunbeam.DAOtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sunbeam.dao.paymentDAO;

class PaymentDAOTest {

	@Test
    void testAddPaymentToDB() {
      
        double finalPayment = 500.0;
        int serviceRequestId = 1;

      
        paymentDAO.addPaymentToDB(finalPayment, serviceRequestId);

       
        System.out.println("tested");
    }

}
