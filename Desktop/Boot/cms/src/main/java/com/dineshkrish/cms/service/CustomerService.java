package com.dineshkrish.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dineshkrish.cms.dao.CustomerDao;
import com.dineshkrish.cms.exception.CustomerNotFoundException;
import com.dineshkrish.cms.model.Customer;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	private int customerCount = 1;
	private List<Customer> customerList = new CopyOnWriteArrayList<>();
	
	public Customer addCustomer(Customer customer) {
//		customer.setCustomerId(customerCount);
//		customerList.add(customer);
//		customerCount++;
//		return customer;
		return customerDao.save(customer);
	}
	
	public List<Customer> getCustomers(){
		//return customerList;
		return customerDao.findAll();
	}
	
	public Customer getCustomer(int customerId){
		//return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();
		
		Optional<Customer> optionalCustomer = customerDao.findById(customerId);
		
		if(!optionalCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer record is not available!");
		}
		return optionalCustomer.get();
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
//		customerList.stream().forEach(c -> {
//			if(c.getCustomerId() == customerId) {
//				c.setCustomerFirstName(customer.getCustomerFirstName());
//				c.setCustomerLastName(customer.getCustomerLastName());
//				c.setCustomerEmailId(customer.getCustomerEmailId());
//			}
//		});
//		return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();
		
		customer.setCustomerId(customerId);
		
		return customerDao.save(customer);
	}
	
	
	public void removeCustomer(int customerId) {
		
//		customerList.stream().forEach(c -> {
//			if(c.getCustomerId() == customerId) {
//				customerList.remove(c);
//			}
//		});
		
		customerDao.deleteById(customerId);
	}

}
