package com.hexagonal.apphexa.domain.ports.in;

import com.hexagonal.apphexa.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
