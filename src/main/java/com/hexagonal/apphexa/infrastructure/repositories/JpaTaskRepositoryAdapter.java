package com.hexagonal.apphexa.infrastructure.repositories;

import com.hexagonal.apphexa.domain.models.Task;
import com.hexagonal.apphexa.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.apphexa.infrastructure.entities.TaskEntity;

import java.util.List;
import java.util.Optional;

public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        if (jpaTaskRepository.existsById(id)) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updateEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updateEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
