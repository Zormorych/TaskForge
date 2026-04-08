package com.pdropalazn.taskforge.projects.domain.port.repository;

import com.pdropalazn.taskforge.projects.domain.model.Project;

public interface ProjectRepositoryPort {

    Project save(Project project);
}
