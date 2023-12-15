package com.hexagonal.apphexa.infrastructure.repositories;

import com.hexagonal.apphexa.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
