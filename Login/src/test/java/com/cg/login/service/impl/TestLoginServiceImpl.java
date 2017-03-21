package com.cg.login.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.cg.login.dao.CustomerDao;
import com.cg.login.model.Customer;

public class TestLoginServiceImpl {
	
	private CustomerDao customerDao;
	private LoginServiceImpl loginServiceImpl;
	
	@Before
	public void setup() {
		customerDao = Mockito.mock(CustomerDao.class);
	}
	
	@Test
	public void getCustomertest(){
		Customer customer = new Customer();
		customer.setUserId("Mack");
		customer.setPassword("password");
		Mockito.when(customerDao.findOne( Mockito.anyString())).thenReturn(customer);
		loginServiceImpl =  new LoginServiceImpl();
		loginServiceImpl.setCustomerDao(customerDao);
		Customer cust = loginServiceImpl.getCustomer("1"); 
		Mockito.verify(customerDao).findOne(Mockito.anyString());
		Assert.assertNotNull(cust);
		
	}

}
