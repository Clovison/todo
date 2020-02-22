package br.com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.service.TodoService;

@RestController
public class HomeController {
	@Autowired
	private TodoService service;
	
	
	@GetMapping("/todos")
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(service.list());
	}

	
	
}
