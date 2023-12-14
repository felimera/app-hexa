package com.hexagonal.apphexa.domain.ports.in;

import com.hexagonal.apphexa.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
