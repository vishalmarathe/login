package com.cg.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.login.model.Customer;

//@Transactional
@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {

	/*@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	public Customer getCustomerById(String customerId) {
		return hibernateTemplate.get(Customer.class, customerId);
	}*/
}
