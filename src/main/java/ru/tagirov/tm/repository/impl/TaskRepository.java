package ru.tagirov.tm.repository.impl;

import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.repository.AbstractRepository;
import ru.tagirov.tm.repository.ITaskRepository;

public class TaskRepository extends AbstractRepository<Task> implements ITaskRepository<Task> {

    public TaskRepository() {
    }
}
