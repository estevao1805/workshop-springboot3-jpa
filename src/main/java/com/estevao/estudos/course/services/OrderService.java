package com.estevao.estudos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estevao.estudos.course.entities.Order;
import com.estevao.estudos.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findByIdOrder(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
