package com.example.task_tracker_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerApiApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(TaskTrackerApiApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
