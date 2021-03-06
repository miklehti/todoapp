package rest.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rest.todo.models.Todo;
import rest.todo.exceptions.NoContentException;
import rest.todo.managers.TodoManager;
import rest.todo.models.TodoRequest;

@RequestMapping("v1/")

@RestController


@Api
public class TodoController {
	
	@Autowired
	private TodoManager todoManager;
	
	 @ApiOperation(value = "Haetaan todo id:llä", response = Todo.class)
	 @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Todo> getTodo(@PathVariable("id") long id) {
	        try {
				return new ResponseEntity<>(todoManager.getTodo(id), HttpStatus.OK);
			} catch (NoContentException e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, e.getHttpStatus());
			}
	    }
	 
	 @ApiOperation(value = "Haetaan kaikki todot")
	 @RequestMapping(value = "/alltodos", method = RequestMethod.GET)
	    public List<Todo> getAllTodos() {
	        return todoManager.getAllTodos();
	    }
	 
	 @ApiOperation(value = "Tallenna todo")
	 @RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	    public void saveTodo(@Valid @RequestBody TodoRequest todo) {
		    todoManager.saveTodo(todo);

	    }
	 
	 @ApiOperation(value = "Päivitä todo")
	 @RequestMapping(value = "/paivita", method = RequestMethod.PUT)
	    public ResponseEntity<Todo> updateTodo(@Valid @RequestBody Todo todo) {
		    Todo todoUpdated;
			try {
				todoUpdated = todoManager.updateTodo(todo);
				return  new ResponseEntity<>(todoUpdated, HttpStatus.OK);
			} catch (NoContentException e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, e.getHttpStatus());
			}
	    }
	 
	 @ApiOperation(value = "Poista todo")
	 @RequestMapping(value = "/poista/{id}", method = RequestMethod.POST)
	    public ResponseEntity<String> deleteTodo(@PathVariable("id") long id) {
	        try {
				return new ResponseEntity<>( todoManager.deleteTodo(id), HttpStatus.OK);
			} catch (NoContentException e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, e.getHttpStatus());
			}
	    }
	 
	 

}
