package com.pdropalazn.taskforge.tasks.domain.port.in;

import com.pdropalazn.taskforge.tasks.domain.model.Task;

import java.util.List;

public interface GetAllTasksUseCase {

    List<Task> getAll();
}
