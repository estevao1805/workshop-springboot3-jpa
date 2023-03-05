package com.estevao.estudos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estevao.estudos.course.entities.Product;
import com.estevao.estudos.course.repositories.ProductRepository;
import com.estevao.estudos.course.services.exceptions.DataBaseException;
import com.estevao.estudos.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findByIdProduct(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Product update(Long id, Product obj) {
		try {
			Product entity;
			entity = repository.getReferenceById(id);			
			entity.setName(obj.getName());
			entity.setDescription(obj.getDescription());
			entity.setPrice(obj.getPrice());
			entity.setImgUrl(obj.getImgUrl());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
