package com.sbrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbrestapi.model.Address;
import com.sbrestapi.service.AddressService;

/**
* <h1>Implementation of REST API for Address!</h1>
* This API is used to save address, get address list,
* get post code by passing suburb, get suburb by passing
* post code.
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/
@RestController
@RequestMapping("/address")
public class AddressController {
	
	/* addressService is used to interact with
	 * repository API
	 * 	 */
	@Autowired
	AddressService addressService;

	/**
	   * This method is used to post the address into database.
	   * @param address 
	   * @return String Confirmation from API
    */
	@PostMapping("/saveAddress")
	public String saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return "Address saved successfully.";
	}

	/**
	   * This method is used to get the address list 
	   * from database.
	   * @return List<Address> returns address list.
	*/
	@GetMapping("/getAddressList")
	public List<Address> getAddressList() {
		return addressService.getAddressList();
	}

	/**
	   * This method is used to get the post code by
	   * passing suburb from database.
	   * @return String returns post code.
	*/
	@GetMapping("/getPostCodeBySuburb/{suburb}")
	public String getPostCodeBySuburb(@PathVariable String suburb) {
		return addressService.getPostCodeBySuburb(suburb);
	}

	/**
	   * This method is used to get the suburb by
	   * passing post code from database.
	   * @return String returns suburb.
	*/
	@GetMapping("/getSuburbByPostCode/{postCode}")
	public String getSuburbByPostCode(@PathVariable String postCode) {
		return addressService.getSuburbByPostCode(postCode);
	}

}
