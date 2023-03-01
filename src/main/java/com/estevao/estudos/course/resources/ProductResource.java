package com.estevao.estudos.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estevao.estudos.course.entities.Product;
import com.estevao.estudos.course.services.ProductService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findByIdProduct(id);
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
