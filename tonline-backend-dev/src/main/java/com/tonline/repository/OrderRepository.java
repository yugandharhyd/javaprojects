package com.tonline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tonline.jpa.OrderData;


@Repository
public interface OrderRepository extends CrudRepository<OrderData, Integer> {
}
