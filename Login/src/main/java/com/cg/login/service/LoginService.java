package com.cg.login.service;

import com.cg.login.model.Customer;

public interface LoginService {
	
	Customer getCustomer(String customerId);

}
