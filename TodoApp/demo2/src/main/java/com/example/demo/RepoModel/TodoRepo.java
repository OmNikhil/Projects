package com.example.demo.RepoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TodoModel;

@Repository
public interface TodoRepo extends JpaRepository<TodoModel,Long> {

    
} 


