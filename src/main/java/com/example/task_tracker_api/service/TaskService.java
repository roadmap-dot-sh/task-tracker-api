/*
 * TaskService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.task_tracker_api.service;

import com.example.task_tracker_api.enums.TaskStatus;
import com.example.task_tracker_api.model.Task;
import com.example.task_tracker_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TaskService.java
 *
 * @author Nguyen
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task add(String description) {
        List<Task> tasks = taskRepository.findAll();
        int id = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;

        Task task = new Task();
        task.setId(id);
        task.setDescription(description);
        task.setStatus(TaskStatus.TODO.name());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        tasks.add(task);
        taskRepository.saveAll(tasks);

        return task;
    }

    public void update(int id, String description) {
        List<Task> tasks = taskRepository.findAll();
        Task t = findById(tasks, id);

        t.setDescription(description);
        t.setUpdatedAt(LocalDateTime.now());

        taskRepository.saveAll(tasks);
    }

    public void delete(int id) {
        List<Task> tasks = taskRepository.findAll();
        tasks.removeIf(t -> t.getId() == id);
        taskRepository.saveAll(tasks);
    }

    public void mark(int id, String status) {
        List<Task> tasks = taskRepository.findAll();
        Task t = findById(tasks, id);

        t.setStatus(status);
        t.setUpdatedAt(LocalDateTime.now());

        taskRepository.saveAll(tasks);
    }

    public List<Task> list(String status) {
        List<Task> tasks = taskRepository.findAll();
        if (status == null) return tasks;

        return tasks.stream()
                .filter(t -> t.getStatus().equals(status))
                .toList();
    }

    private Task findById(List<Task> tasks, int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
