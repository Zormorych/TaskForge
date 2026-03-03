package com.pdropalazn.taskforge.tasks.api;


import com.pdropalazn.taskforge.identity.domain.model.vo.UserId;
import com.pdropalazn.taskforge.tasks.api.request.CreateTaskRequest;
import com.pdropalazn.taskforge.tasks.domain.model.Task;
import com.pdropalazn.taskforge.tasks.domain.model.TaskPriority;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskDescription;
import com.pdropalazn.taskforge.tasks.domain.model.vo.TaskTitle;
import com.pdropalazn.taskforge.tasks.domain.port.in.CreateTaskUseCase;
import com.pdropalazn.taskforge.tasks.domain.port.in.dto.CreateTaskCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }


    //RequestBody sirve para vincular el body del JSON a un objeto Java

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTaskRequest request) {

        //se crea un dto con el create y conversionamos a Command de dominio
        CreateTaskCommand command = new CreateTaskCommand(
                request.projectId(),
                new TaskTitle(request.title()),
                request.description() == null ? null : new TaskDescription(request.description()), //si viene nulldeja null y si viene texto crea VO
                TaskPriority.valueOf(request.priority()),
                request.dateTime() == null ? LocalDateTime.now() : request.dateTime(),
                request.assigneeId() == null ? null : new UserId(request.assigneeId())
        );

        Task created = createTaskUseCase.create(command);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created.getTaskId().toString());
    }

}
