package com.hexagonal.apphexa.infrastructure.controllers;

import com.hexagonal.apphexa.application.services.TaskService;
import com.hexagonal.apphexa.domain.models.AdditionalTaskInfo;
import com.hexagonal.apphexa.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
    }

    @GetMapping(path = "/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "taskId") Long taskId) {
        return taskService
                .getTask(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "taskId") Long taskId, @RequestBody Task updateTask) {
        return taskService
                .updateTask(taskId, updateTask)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable(name = "taskId") Long taskId) {
        if (taskService.deleteTask(taskId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/{taskId}/additionalInfor")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable(name = "taskId") Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return ResponseEntity.ok(additionalTaskInfo);
    }
}
