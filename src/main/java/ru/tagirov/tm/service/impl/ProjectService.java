package ru.tagirov.tm.service.impl;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.repository.IProjectRepository;
import ru.tagirov.tm.service.AbstractService;
import ru.tagirov.tm.service.IProjectService;

import java.util.Map;

public class ProjectService extends AbstractService<Project> implements IProjectService<Project> {

    private IProjectRepository<Project> projectRepository;

    public ProjectService(final IProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
}
