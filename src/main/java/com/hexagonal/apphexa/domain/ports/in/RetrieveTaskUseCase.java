package com.hexagonal.apphexa.domain.ports.in;

import com.hexagonal.apphexa.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);

    List<Task> getAllTask();
}
