package com.jonathanvasquez.order_microservice.repository;

import org.springframework.stereotype.Repository;

import com.jonathanvasquez.order_microservice.entity.OrderEntity;

@Repository
public interface OrderRepository {
	OrderEntity saveOrder(OrderEntity order) throws Exception;
}
