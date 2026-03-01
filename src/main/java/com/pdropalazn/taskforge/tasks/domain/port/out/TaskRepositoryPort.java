package com.pdropalazn.taskforge.tasks.domain.port.out;

import com.pdropalazn.taskforge.tasks.domain.model.Task;

public interface TaskRepositoryPort {

    Task save (Task task);

}
