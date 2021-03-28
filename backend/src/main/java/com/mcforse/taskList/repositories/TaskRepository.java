package com.mcforse.taskList.repositories;

import com.mcforse.taskList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("update Task t set t.complete = :status where t.id = :id")
    void updateStatus(long id, boolean status);

    boolean existsById(long id);
}
