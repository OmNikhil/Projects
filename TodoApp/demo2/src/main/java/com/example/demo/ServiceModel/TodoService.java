package com.example.demo.ServiceModel;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.Model.TodoModel;
import com.example.demo.RepoModel.TodoRepo;

@Service
public class TodoService {

    private final TodoRepo repo;

    public TodoService(TodoRepo repo) {
        this.repo = repo;
    }

    public List<TodoModel> getAllTodos() {
        return repo.findAll();
    }

    public TodoModel addTodo(TodoModel todo) {
        return repo.save(todo);
    }

    public TodoModel updateTodo(Long id, TodoModel updatedTodo) {
        TodoModel existing = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        existing.setTask(updatedTodo.getTask());
        existing.setDone(updatedTodo.isDone());
        return repo.save(existing);
    }

    public void deleteTodo(Long id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
