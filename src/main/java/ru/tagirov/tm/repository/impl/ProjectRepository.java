package ru.tagirov.tm.repository.impl;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.repository.AbstractRepository;
import ru.tagirov.tm.repository.IProjectRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectRepository extends AbstractRepository<Project> implements IProjectRepository<Project> {

    public ProjectRepository() {
    }
}
