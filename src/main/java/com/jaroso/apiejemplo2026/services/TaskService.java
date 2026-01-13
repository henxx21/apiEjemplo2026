package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll();
    Optional<Task> findById(Long id);
    Optional<Task> findByTitle(String title);

    Task saveTask(Task Task);

    void deleteAll();
    void deleteById(Long id);
}
