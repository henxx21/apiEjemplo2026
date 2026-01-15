package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.entities.Task;
import com.jaroso.apiejemplo2026.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
//probando rama develop
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskRepository.findAll());

    }
@GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(task.get());

    }





}
