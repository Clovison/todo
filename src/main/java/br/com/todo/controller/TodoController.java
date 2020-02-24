package br.com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.dto.TodoDTO;
import br.com.todo.entity.Todo;
import br.com.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService service;
	
	
	@GetMapping
	public Page<TodoDTO> page(@PageableDefault(page=0, size=5, direction=Direction.ASC, sort="id") Pageable pageable ) {
			Page<Todo> page = service.findAll(pageable);
			return TodoDTO.converter(page);
	}

	@GetMapping("/usuario/{username}")
	public Page<TodoDTO> pageUsername(@PathVariable String username, @PageableDefault(page=0, size=5, direction=Direction.ASC, sort="id") Pageable pageable ) {
			Page<Todo> page = service.findByUsername(username, pageable);
			return TodoDTO.converter(page);
		}
	
	@GetMapping("/home")
	public String home() {
			return "Olá Clóvison";
		}
		
	
	
}
