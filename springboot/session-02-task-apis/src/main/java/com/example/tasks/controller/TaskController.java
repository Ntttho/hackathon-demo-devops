package com.example.tasks.controller;

//import com.example.tasks.model.Task;
import com.example.tasks.entity.Task;
import com.example.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;
//    private static final List<Task> TASKS = new ArrayList<>();



    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/api/create")
    public Task createTask(@RequestParam String name){
        Task task = new Task();
        task.setName(name);
        return taskRepository.save(new Task());
    }
}
