package com.sbrestapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.sbrestapi.model.Address;

/**
* <h1>Repository for Address!</h1>
* AddressRepository is used to perform CRUD  
* operations for address.
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
