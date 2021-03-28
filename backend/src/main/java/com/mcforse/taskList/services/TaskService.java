package com.mcforse.taskList.services;

import com.mcforse.taskList.dto.AddTaskRequest;
import com.mcforse.taskList.dto.UpdateTaskRequest;
import com.mcforse.taskList.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(long id);

    Task save(AddTaskRequest request);

    void updateStatus(UpdateTaskRequest request);

    void deleteById(long id);

    boolean existById(long id);
}
