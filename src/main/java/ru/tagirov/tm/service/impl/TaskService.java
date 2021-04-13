package ru.tagirov.tm.service.impl;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.repository.AbstractRepository;
import ru.tagirov.tm.repository.IProjectRepository;
import ru.tagirov.tm.repository.ITaskRepository;
import ru.tagirov.tm.repository.impl.TaskRepository;
import ru.tagirov.tm.service.AbstractService;
import ru.tagirov.tm.service.IProjectService;
import ru.tagirov.tm.service.ITaskService;

import java.util.Map;

public class TaskService extends AbstractService<Task> implements ITaskService<Task> {

    private ITaskRepository<Task> taskRepository;

    public TaskService(final ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
}
