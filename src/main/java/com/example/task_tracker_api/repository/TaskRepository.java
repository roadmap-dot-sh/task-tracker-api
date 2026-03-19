/*
 * TaskRepository.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.task_tracker_api.repository;

import com.example.task_tracker_api.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * TaskRepository.java
 *
 * @author Nguyen
 */
@Repository
public class TaskRepository {
    private static final String FILE_PATH = "tasks.json";
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public List<Task> findAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
                return new ArrayList<>();
            }
            if (file.length() == 0) return new ArrayList<>();

            return new ArrayList<>(Arrays.asList(mapper.readValue(file, Task[].class)));
        } catch (Exception e) {
            throw new RuntimeException("Error while reading file", e);
        }
    }

    public void saveAll(List<Task> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), tasks);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving tasks", e);
        }
    }
}
