package rest.todo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rest.todo.entities.TodoEntity;
import rest.todo.models.Todo;;

public interface ITodoRepository {
	
	 	List<TodoEntity> getAllTodos();
	 	
	 	TodoEntity getTodoById(Long todoId);
	 	
	    void addTodoEntity(TodoEntity todoEntity);
	    
	    TodoEntity updateTodoEntity(TodoEntity todoEntity);
	    
	    void deleteTodoEntity(Long todoId);

}
