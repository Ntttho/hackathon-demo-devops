package com.example.tasks.controller;

import com.example.tasks.entity.Task;
import com.example.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/api/create")
    public Task createTask(
            @RequestParam(required = false) String name,
            @RequestBody(required = false) Task bodyTask
    ) {
        Task task = new Task();
        if (bodyTask != null && bodyTask.getName() != null && !bodyTask.getName().isBlank()) {
            task.setName(bodyTask.getName());
        } else if (name != null) {
            task.setName(name);
        }
        return taskRepository.save(task);
    }
}
