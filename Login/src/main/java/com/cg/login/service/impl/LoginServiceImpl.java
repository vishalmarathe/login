package com.cg.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.login.dao.CustomerDao;
import com.cg.login.model.Customer;
import com.cg.login.service.LoginService;

@Controller
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomer(String customerId) {
		return customerDao.findOne(customerId);
	}

}
