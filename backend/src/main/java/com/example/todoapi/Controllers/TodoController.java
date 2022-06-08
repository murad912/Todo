package com.example.todoapi.Controllers;

import com.example.todoapi.entities.Todo;
import com.example.todoapi.entities.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public Todo newTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getTodos(){
        return this.todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId){

        var todo= todoRepository.findById(todoId);
        return todo;
    }

    @PutMapping("/{id}")
    Todo update(@RequestBody Todo newTodo, @PathVariable Long id) {

        return todoRepository.findById(id)
                .map(oldTodo -> {
                    oldTodo.setTitle(newTodo.getTitle());
                    oldTodo.setCompleted(newTodo.getCompleted());
                    return todoRepository.save(oldTodo);
                })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return todoRepository.save(newTodo);
                });
    }
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        this.todoRepository.deleteById(todoId);
    }
}
