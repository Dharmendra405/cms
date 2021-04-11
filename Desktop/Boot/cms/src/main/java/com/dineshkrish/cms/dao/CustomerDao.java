package com.dineshkrish.cms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dineshkrish.cms.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{

	@Override
	List<Customer> findAll();
	
}
