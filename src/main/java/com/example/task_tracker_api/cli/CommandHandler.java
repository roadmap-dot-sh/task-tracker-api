/*
 * CommandHandler.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.task_tracker_api.cli;

import com.example.task_tracker_api.enums.TaskStatus;
import com.example.task_tracker_api.model.Task;
import com.example.task_tracker_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandHandler.java
 *
 * @author Nguyen
 */
@Component
public class CommandHandler implements CommandLineRunner {
    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("No command provided");
            return;
        }

        String command = args[0];

        try {
            switch (command) {
                case "add":
                    Task t = taskService.add(args[1]);
                    System.out.println("Task added (ID: " + t.getId() + ")");
                    break;
                case "update":
                    taskService.update(Integer.parseInt(args[1]), args[2]);
                    System.out.println("Task updated");
                    break;
                case "delete":
                    taskService.delete(Integer.parseInt(args[1]));
                    System.out.println("Task deleted");
                    break;
                case "mark-in-progress":
                    taskService.mark(Integer.parseInt(args[1]), TaskStatus.IN_PROGRESS.name());
                    break;
                case "mark-completed":
                    taskService.mark(Integer.parseInt(args[1]), TaskStatus.COMPLETED.name());
                    break;
                case "list":
                    String status = args.length > 1 ? args[1] : null;
                    taskService.list(status).forEach(task ->
                            System.out.println(task.getId() + " | " +
                                    task.getDescription() + " | " +
                                    task.getStatus())
                    );
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
