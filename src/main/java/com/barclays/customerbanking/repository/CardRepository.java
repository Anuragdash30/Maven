package com.barclays.customerbanking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.barclays.customerbanking.entity.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {
	List<Card> findByCustomer_customerId(Integer id);
}
