package com.jaroso.apiejemplo2026.repositories;

import com.jaroso.apiejemplo2026.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

Optional<Task> findByTitle(String title);


}
