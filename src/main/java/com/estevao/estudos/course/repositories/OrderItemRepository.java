package com.estevao.estudos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estevao.estudos.course.entities.OrderItem;
import com.estevao.estudos.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
