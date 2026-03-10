package com.pdropalazn.taskforge.tasks.application.usecase.port.dto;


import com.pdropalazn.taskforge.identity.domain.model.vo.UserId;
import com.pdropalazn.taskforge.tasks.domain.model.TaskPriority;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskDescription;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskTitle;

import java.time.LocalDateTime;
import java.util.UUID;

//command/dto se encarga de gestionar la entrada del caso de uso
//aqui no viaja taskId porque eso lo gestiona el dominio
//es un objeto para transportar datos hacua el caso de uso (createtaskservice)
public record CreateTaskCommand(
        UUID projectId,
        TaskTitle title,
        TaskDescription description,
        TaskPriority priority,
        LocalDateTime dueDate,
        UserId assigneeId
) { }
