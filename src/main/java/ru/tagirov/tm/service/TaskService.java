package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.repository.ProjectRepository;
import ru.tagirov.tm.repository.TaskRepository;

import java.util.Map;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Map<String, Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findOne(Task task){
        return taskRepository.findOne(task);
    }

    public void persist(final Task task){
        if (task == null){
            System.out.println("YOU TASK IS IVALID!");
        }
        else if (task.getName() == null || task.getDescription() == null || task.getDateCreate() == null){
            System.out.println("YOU VALUES IS INVALID!");
        }
        else if (task.getName().equals("") || task.getDescription().equals("") || task.getDateCreate().equals("")){
            System.out.println("YOU VALUES IS INVALID!");
        }else {
            taskRepository.persist(task);
        }
    }

    public Task merge(final Task task){
        if (task == null){
            System.out.println("YOU TASK IS IVALID!");
        }
        else if (task.getName() == null || task.getDescription() == null || task.getDateCreate() == null){
            System.out.println("YOU VALUES IS INVALID!");
        }
        else if (task.getName().equals("") || task.getDescription().equals("") || task.getDateCreate().equals("")){
            System.out.println("YOU VALUES IS INVALID!");
        }else {
            taskRepository.persist(task);
        }
        return taskRepository.merge(task);
    }

    public void remove(Task task){
        taskRepository.remove(task);
    }

    public void removeAll(){
        taskRepository.removeAll();
    }
}
