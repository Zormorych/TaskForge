package com.pdropalazn.taskforge.projects.application.usecase.port.dto;

import com.pdropalazn.taskforge.projects.domain.model.vo.ProjectDescription;
import com.pdropalazn.taskforge.projects.domain.model.vo.ProjectName;

//Command de applicacion que lleva los datos al caso de uso
public record CreateProjectCommand(
        ProjectName name,
        ProjectDescription description
) { }
