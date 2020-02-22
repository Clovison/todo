package br.com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.entity.Todo;
import br.com.todo.repository.TodoRepository;




@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	
	public void save(Todo todo) {
		repository.save(todo);
	}
	
	public List<Todo> list(){
		return repository.findAll();
	}
}
