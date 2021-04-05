package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.Task;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaskRepository {
    private Map<String, Task> taskMap = new LinkedHashMap<>();

    public Map<String, Task> findAll(){
        return taskMap;
    }

    public Task findOne(Task task){
        return taskMap.get(task.getId());
    }

    public void persist(final Task task){
        taskMap.put(task.getId(), task);
    }

    public Task merge(final Task task){
        taskMap.put(task.getId(), task);
        return taskMap.get(task.getId());
    }

    public void remove(Task task){
        taskMap.remove(task.getId());
    }

    public void removeAll(){
        taskMap.clear();
    }
}
