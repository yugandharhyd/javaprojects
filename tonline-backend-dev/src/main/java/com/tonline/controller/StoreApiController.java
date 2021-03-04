package com.tonline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonline.dto.CustomerDTO;
import com.tonline.service.CustomerService;

/**
* <h1>Implementation of REST API for Store activities!</h1>
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-03-02
*/
@RestController
public class StoreApiController {

	@Autowired
	private CustomerService customerService;

	/**
	   * The getActiveCustomersWithNoOrders is used to get
	   * the active customers who are not placed any orders
	   * @return List<CustomerDTO>
    */
    @GetMapping("/activeCustomersNotOrderedYet")
    public  ResponseEntity<List<CustomerDTO>> getActiveCustomersNotOrderedYet() {
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();

		customerDTOList = customerService.getActiveCustomersNotOrderedYet();
    	if (customerDTOList==null || customerDTOList.isEmpty()) {
    	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }

	/**
	   * The getTotalValueOfCompletedOrdersFromActiveCustomers is used to get
	   * the total value of completed orders for active customers.
	   * @return String
    */
    @GetMapping("/totalValueOfCompletedOrdersFromActiveCustomers")
    public ResponseEntity<String> getTotalValueOfCompletedOrdersFromActiveCustomers() {
        String totalOrderValue = customerService.getTotalValueOfCompletedOrdersFromActiveCustomers();
    	if (Double.parseDouble(totalOrderValue)==0) {
  	      	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(totalOrderValue, HttpStatus.OK);
    }

}
