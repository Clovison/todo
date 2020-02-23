package br.com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.dto.TodoDTO;
import br.com.todo.entity.Todo;
import br.com.todo.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService service;
	
	
	@GetMapping("/todos")
	public Page<TodoDTO> page(@RequestParam(required = false) String userName,    @PageableDefault(page=0, size=5, direction=Direction.ASC, sort="id") Pageable pageable ) {
		
		
		
		if (userName == null) {
			Page<Todo> page = service.findAll(pageable);
			return TodoDTO.converter(page);
		} else {
			Page<Todo> page = service.findByUsername(userName, pageable);
			return TodoDTO.converter(page);
		}
		
	}

	
	
}
