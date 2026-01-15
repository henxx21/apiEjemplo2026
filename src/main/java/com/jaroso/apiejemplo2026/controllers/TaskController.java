package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.entities.Task;
import com.jaroso.apiejemplo2026.repositories.TaskRepository;
import com.jaroso.apiejemplo2026.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
//probando rama develop
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskRepository.findAll());

    }

    @GetMapping("/tasks/order/{order}")
    public ResponseEntity<List<Task>> getAllTaskOrder(@PathVariable String order){
        return ResponseEntity.ok(taskService.findAllOrderByTitle(order));
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/tasks/tittle/{tittle}")
    public ResponseEntity<Task> getTaskByTittle(@PathVariable String tittle){
        Optional<Task> task = taskService.findByTitle(tittle);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        //return ResponseEntity.ok(taskService.saveTask(task));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }

    @PutMapping("/tasks")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            //Si el id es válido lo borramos y devolvemos 204
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } else {
            //Si el id no es de una tarea válida
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/tasks")
    public ResponseEntity<Task> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
