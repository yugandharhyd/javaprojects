package com.tonline.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonline.dto.CustomerDTO;
import com.tonline.jpa.Customer;
import com.tonline.jpa.OrderData;
import com.tonline.jpa.OrderStatus;
import com.tonline.repository.CustomerRepository;
import com.tonline.repository.OrderRepository;

/**
* <h1>CustomerService is used to implement business logic
* by interacting with database repositories!</h1>
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-03-02
*/

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	private static ModelMapper modelMapper = new ModelMapper();

	/**
	   * The getActiveCustomersWithNoOrders is used to get
	   * the active customers who are not placed any orders
	   * by interacting with repositories
	   * @return List<CustomerDTO>
    */
	public List<CustomerDTO> getActiveCustomersNotOrderedYet() {

		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		Iterable<Customer> customerList = customerRepository.findAll();
		Iterable<OrderData> orderDataList = orderRepository.findAll();
		List<Integer> customerIdList = new ArrayList<Integer>();

		for (OrderData orderData : orderDataList) {
			 if(!customerIdList.contains(orderData.getCustomerId())) {
				 customerIdList.add(orderData.getCustomerId());
			}
		}

		for (Customer customer : customerList) {
			if (customer.isStatus() && !customerIdList.contains(customer.getCustomerId())) {
				customerDTOList.add(modelMapper.map(customer, CustomerDTO.class));
			}
		}
		return customerDTOList;
		
	}
	
	/**
	   * The getTotalValueOfCompletedOrdersFromActiveCustomers is used to get
	   * the total value of completed orders for active customers
	   * by interacting with repositories
	   * @return String
    */
	public String getTotalValueOfCompletedOrdersFromActiveCustomers() {

		double totalCost = 0;
		Iterable<Customer> customerList = customerRepository.findAll();
		Iterable<OrderData> orderDataList = orderRepository.findAll();

		for (Customer customer : customerList) {
			if (customer.isStatus()) {
				for (OrderData orderData : orderDataList) {
					if ((customer.getCustomerId() == orderData.getCustomerId())
							&& orderData.getOrderStatus().equals(OrderStatus.COMPLETED)) {
						totalCost = totalCost + orderData.getTotalCost();
					}
				}
			}
		}

		return String.valueOf(totalCost);
	}

}
