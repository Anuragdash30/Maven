package com.barclays.customerbanking.repository;

import org.springframework.data.repository.CrudRepository;

import com.barclays.customerbanking.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
