package com.cg.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.login.model.Customer;
import com.cg.login.service.LoginService;

@RestController
public class LoginServiceController {
	
	@Autowired
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login/getCustomerById")
	public Customer getCustomerById(String customerId) {
		return loginService.getCustomer(customerId);
	}

}
