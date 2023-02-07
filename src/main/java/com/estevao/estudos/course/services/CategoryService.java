package com.estevao.estudos.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estevao.estudos.course.entities.Category;
import com.estevao.estudos.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findByIdCategory(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
