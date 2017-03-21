package com.cg.entrypoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.cg.login.model.Customer;
import com.cg.login.service.LoginService;
import com.cg.login.service.impl.LoginServiceImpl;



public class TestLoginServiceController {

private LoginService loginService;
private LoginServiceController loginServiceController;
	
	@Before
	public void setup() {
		loginService = Mockito.mock(LoginServiceImpl.class);
	}
	
	@Test
	public void getCustomerByIdTest(){
		Customer customer = new Customer();
		customer.setUserId("Mack");
		customer.setPassword("password");
		Mockito.when(loginService.getCustomer(Mockito.anyString()) ).thenReturn(customer);
		loginServiceController = new LoginServiceController();
		loginServiceController.setLoginService(loginService);
		Customer c = loginServiceController.getCustomerById("1");
		Mockito.verify(loginService).getCustomer(Mockito.anyString());
		Assert.assertNotNull(c);
	}
	
}
