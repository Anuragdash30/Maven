package com.barclays.customerbanking.service;

import java.util.List;

import com.barclays.customerbanking.dto.CardDTO;
import com.barclays.customerbanking.dto.CustomerCardsDTO;
import com.barclays.customerbanking.dto.CustomerDTO;
import com.barclays.customerbanking.exception.BarclaysException;

/**
 * CardCustomerService - Interface for card customer service api
 * @author Ved
 *
 */
public interface CardCustomerService {
	public CustomerCardsDTO getCustomerDetails(Integer customerId) throws BarclaysException;
	public Integer addCustomer(CustomerDTO customerDTO) throws BarclaysException;
	public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws BarclaysException;
	public void deleteCustomer(Integer customerId) throws BarclaysException;
	public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete) throws BarclaysException;	
		
}

