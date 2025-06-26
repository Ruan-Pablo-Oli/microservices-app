package com.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order.model.ItemOrder;

public interface ItemOrderRepositoru extends JpaRepository<ItemOrder, Long> {

}
