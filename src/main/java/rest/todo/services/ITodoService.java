package rest.todo.services;

import java.util.List;
import rest.todo.entities.TodoEntity;
import rest.todo.exceptions.NoContentException;

public interface ITodoService {

    List<TodoEntity> getAllTodos();

    TodoEntity getTodoById(Long todoId);

    void addTodoEntity(TodoEntity todoEntity);

    TodoEntity updateTodoEntity(TodoEntity todoEntity) throws NoContentException;

    void deleteTodoEntity(Long todoId) throws NoContentException;
}
