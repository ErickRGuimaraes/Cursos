package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.OrderItem;
import com.spring.entities.pk.OrderItemPK;

// This is optional, but it is a good practice to annotate the repository interface with @Repository
// is optional because JpaRepository already has the @Repository annotation
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}

