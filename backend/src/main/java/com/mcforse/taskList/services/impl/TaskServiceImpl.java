package com.mcforse.taskList.services.impl;

import com.mcforse.taskList.dto.AddTaskRequest;
import com.mcforse.taskList.dto.UpdateTaskRequest;
import com.mcforse.taskList.exceptions.NotFoundException;
import com.mcforse.taskList.models.Task;
import com.mcforse.taskList.repositories.TaskRepository;
import com.mcforse.taskList.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task findById(long id) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new NotFoundException("task with id " + id);
        }

        return optionalTask.get();
    }

    @Override
    @Transactional
    public Task save(AddTaskRequest request) {
        Task newTask = Task.builder()
                .title(request.getTitle())
                .note(request.getNote())
                .build();

        return repository.save(newTask);
    }

    @Override
    @Transactional
    public void updateStatus(UpdateTaskRequest request) {
        repository.updateStatus(request.getId(), request.getComplete());
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("task with id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existById(long id) {
        return repository.existsById(id);
    }
}
