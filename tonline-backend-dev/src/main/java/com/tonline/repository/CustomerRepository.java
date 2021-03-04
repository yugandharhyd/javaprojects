package com.tonline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tonline.jpa.Customer;

/**
* <h1>Interface for CRUD operation from database!</h1>
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-03-02
*/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
