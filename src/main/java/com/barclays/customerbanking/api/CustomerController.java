package com.barclays.customerbanking.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.customerbanking.constants.SystemConstants;
import com.barclays.customerbanking.dto.CardDTO;
import com.barclays.customerbanking.dto.CustomerCardsDTO;
import com.barclays.customerbanking.dto.CustomerDTO;
import com.barclays.customerbanking.exception.BarclaysException;
import com.barclays.customerbanking.service.CardCustomerService;

/**
 * CustomerController - Rest api for customer details
 * @author Anurag
 * 
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CardCustomerService cardCustomerService;
	
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<CustomerCardsDTO> getCustomer(@PathVariable Integer customerId) throws BarclaysException {
		CustomerCardsDTO customer = cardCustomerService.getCustomerDetails(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	
	@PostMapping("/customer/new")
	public ResponseEntity<Integer> addCustomer(@RequestBody CustomerDTO customer) throws BarclaysException {
		Integer id = cardCustomerService.addCustomer(customer);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	@PostMapping("/customer/{id}/newcard")
	public ResponseEntity<String> issueCard(@PathVariable Integer id, @RequestBody CardDTO card) throws BarclaysException {
		cardCustomerService.issueCardToExistingCustomer(id, card);
		return new ResponseEntity<>(SystemConstants.CARD_ISSUSED_SUCCESS_RESPONSE, HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) throws BarclaysException {
		cardCustomerService.deleteCustomer(id);
		return new ResponseEntity<>(SystemConstants.CUSTOMER_DELETE_SUCCESS_RESPONSE, HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}/cards")
	public ResponseEntity<String> deleteCustomerCards(@PathVariable Integer id, @RequestBody List<Integer> cardIds) throws BarclaysException {
		cardCustomerService.deleteCardOfExistingCustomer(id, cardIds);
		return new ResponseEntity<>(SystemConstants.CUSTOMER_DELETE_SUCCESS_RESPONSE, HttpStatus.OK);
	}
}
