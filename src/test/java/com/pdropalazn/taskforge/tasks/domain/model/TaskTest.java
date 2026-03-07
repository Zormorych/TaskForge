package com.pdropalazn.taskforge.tasks.domain.model;

import com.pdropalazn.taskforge.identity.domain.model.vo.UserId;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskDescription;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskTitle;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskTest {

    @Test
    void shouldCreateTaskWithValidData(){
        //Arrange (preparacion)
        UUID projectId = UUID.randomUUID();
        TaskTitle title = new TaskTitle("First Happy Path Test");
        TaskDescription description = new TaskDescription("This is also to practice JUnit, this is prob my first test alone");
        TaskPriority priority = TaskPriority.HIGH;
        LocalDateTime dueDate = LocalDateTime.of(2026, 3, 10, 18, 0);
        UserId userAssignedId = new UserId(UUID.randomUUID());
        //Act (Ejecución)
         Task task = Task.create(projectId, title, description, priority, dueDate, userAssignedId);
        //Assert (Verificación)
        assertNotNull(task);
        assertNotNull(task.getTaskId());
        assertEquals(TaskStatus.TO_DO, task.getStatus());
    }



}
