package com.jonathanvasquez.payment_microservice.rest;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.jonathanvasquez.payment_microservice.entity.OrderEntity;
import com.jonathanvasquez.payment_microservice.repository.OrderRepository;

@Service
public class OrderRest implements OrderRepository{

	@Override
	public OrderEntity getOrderByID(Long orderID) throws Exception {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(orderID);
		orderEntity.setDiscount(0.0);
		orderEntity.setIdCliente(Long.valueOf("12"));
		orderEntity.setOrderDate(new Date());
		orderEntity.setStatus("paid");
		orderEntity.setSubTotal(122.22);
		orderEntity.setTotalPay(122.22);
		return orderEntity;
	}

}
