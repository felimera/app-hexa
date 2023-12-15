package com.hexagonal.apphexa.infrastructure.config;

import com.hexagonal.apphexa.application.services.TaskService;
import com.hexagonal.apphexa.application.usecases.*;
import com.hexagonal.apphexa.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.apphexa.domain.ports.out.ExternalServicePort;
import com.hexagonal.apphexa.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.apphexa.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.apphexa.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUserCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
