package br.com.todo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.todo.entity.Todo;


public class TodoDTO {

	
	private Long id;
	private String username;
	private String description;
	private LocalDateTime targetDate;
	private boolean isDone;
	
	public TodoDTO(Todo todo) {
		this.id = todo.getId();
		this.username = todo.getUsername();
		this.description = todo.getDescription();
		this.targetDate = todo.getTargetDate();
	}
	
	
	public Long getId() {
		return id;
	}



	public String getUsername() {
		return username;
	}




	public String getDescription() {
		return description;
	}



	public LocalDateTime getTargetDate() {
		return targetDate;
	}


	


	public boolean isDone() {
		return isDone;
	}






	public static Page<TodoDTO> converter(Page<Todo> todos) {
		return todos.map(TodoDTO::new);
	}
}
