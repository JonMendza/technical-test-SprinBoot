package com.jonathanvasquez.order_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jonathanvasquez.order_microservice.entity.ItemOrderEntity;

@Repository
public interface OrderDetailRepository {
	
	List<ItemOrderEntity> saveDetailOrder(List<ItemOrderEntity> orderDetail) throws Exception;
}
