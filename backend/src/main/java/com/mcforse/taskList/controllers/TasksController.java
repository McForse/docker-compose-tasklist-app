package com.mcforse.taskList.controllers;

import com.mcforse.taskList.dto.AddTaskRequest;
import com.mcforse.taskList.dto.UpdateTaskRequest;
import com.mcforse.taskList.exceptions.NotFoundException;
import com.mcforse.taskList.models.Task;
import com.mcforse.taskList.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/task")
@RequiredArgsConstructor
public class TasksController {
    private final TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> allTask() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> taskById(@PathVariable long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody @Valid AddTaskRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable long id, @RequestBody @Valid UpdateTaskRequest request) {
        if (id != request.getId()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ids do not match");
        service.updateStatus(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
