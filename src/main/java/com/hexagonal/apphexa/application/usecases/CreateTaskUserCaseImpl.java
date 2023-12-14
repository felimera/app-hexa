package com.hexagonal.apphexa.application.usecases;

import com.hexagonal.apphexa.domain.models.Task;
import com.hexagonal.apphexa.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.apphexa.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUserCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUserCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
