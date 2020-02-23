package br.com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Todo> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Page<Todo> findByUsername(String userName,Pageable pageable){
		return repository.findByUsername(userName,pageable);
	}
}
