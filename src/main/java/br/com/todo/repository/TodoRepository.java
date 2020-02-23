package br.com.todo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import br.com.todo.entity.Todo;

public interface TodoRepository  extends JpaRepository<Todo, Long>{
	public Page<Todo> findByUsername(String userName,Pageable page);

}
