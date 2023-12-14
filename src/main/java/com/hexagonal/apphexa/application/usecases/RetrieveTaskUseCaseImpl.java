package com.hexagonal.apphexa.application.usecases;

import com.hexagonal.apphexa.domain.models.Task;
import com.hexagonal.apphexa.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.apphexa.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepositoryPort.findAll();
    }
}
