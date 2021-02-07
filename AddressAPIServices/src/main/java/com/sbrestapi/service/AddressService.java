package com.sbrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbrestapi.model.Address;
import com.sbrestapi.repository.AddressRepository;

/**
* <h1>Service for Address!</h1>
* It is used interact with AddressRepository
* and implement required logic at service level.
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public void saveAddress(Address address) {
		addressRepository.save(address);
	}
	
	public List<Address> getAddressList() {
		List<Address> addressList = new ArrayList<Address>();
		addressRepository.findAll().forEach(address -> addressList.add(address));
		return addressList;
	}
	
	public String getPostCodeBySuburb(String suburb) {
		List<Address> addressList = getAddressList();
		Address matchingAddress = addressList.stream().
				filter(address -> address.getSuburb().equalsIgnoreCase(suburb)).
				findAny().orElse(null);
		return matchingAddress!=null ? matchingAddress.getPostCode() : null;
	}

	public String getSuburbByPostCode(String postCode) {
		List<Address> addressList = getAddressList();
		Address matchingAddress = addressList.stream().
				filter(address -> address.getPostCode().equalsIgnoreCase(postCode)).
				findAny().orElse(null);
		return matchingAddress!=null ? matchingAddress.getSuburb() : null;
	}
}
