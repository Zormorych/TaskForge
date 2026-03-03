package com.pdropalazn.taskforge.tasks.api.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateTaskRequest(
        UUID projectId,
        String title,
        String description,
        String priority,
        LocalDateTime dateTime,
        UUID assigneeId
) {
}
