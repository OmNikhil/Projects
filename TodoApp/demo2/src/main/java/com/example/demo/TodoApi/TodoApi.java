package com.example.demo.TodoApi;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.TodoModel;
import com.example.demo.ServiceModel.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoApi {

    private final TodoService service;

    public TodoApi(TodoService service) {
        this.service = service;
    }

    @GetMapping("/getTodos")
    public List<TodoModel> getTodos() {
        return service.getAllTodos();
    }

    @PostMapping("/addTodo")
    public TodoModel addTodo(@RequestBody TodoModel todo) {
        return service.addTodo(todo);
    }

    @PutMapping("/{id}")
    public TodoModel updateTodo(@PathVariable Long id, @RequestBody TodoModel updatedTodo) {
        return service.updateTodo(id, updatedTodo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
    }

    @DeleteMapping
    public void deleteAllTodos() {
        service.deleteAll();
    }
}
