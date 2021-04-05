package ru.tagirov.tm;

import ru.tagirov.tm.Command.*;
import ru.tagirov.tm.repository.ProjectRepository;
import ru.tagirov.tm.repository.TaskRepository;
import ru.tagirov.tm.service.ProjectService;
import ru.tagirov.tm.service.TaskService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bootstrap {

    Map<String, AbstractCommand> commands = new LinkedHashMap<>();
    public ProjectRepository projectRepository = new ProjectRepository();
    public ProjectService projectService = new ProjectService(projectRepository);
    public TaskRepository taskRepository = new TaskRepository();
    public TaskService taskService = new TaskService(taskRepository);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str;

    public void start() throws IOException {
        init();
        System.out.println("***WELCOME TO TASK MANAGER***");
        while (!(str = reader.readLine()).equals("Exit")){
            for(Map.Entry<String, AbstractCommand> tmp : commands.entrySet()){
                if (tmp.getKey().equals(str)){
                    tmp.getValue().execute();
                }
            }
        }
    }

    private void registry(final AbstractCommand command){
        final String commandName = command.getName();
        final String commandDescription = command.getDescripion();

        if (commandName == null || commandName.isEmpty()){
            System.out.println("Command don't registration!");
        }
        if (commandDescription == null || commandDescription.isEmpty()){
            System.out.println("Command don't registration!");
        }
        commands.put(commandName, command);
    }

    private void init(){
        registry(new ProjectCreateCommand(this));
        registry(new ProjectUpdateCommand(this));
        registry(new ProjectListCommand(this));
        registry(new ProjectRemoveCommand(this));
        registry(new ProjectClearCommand(this));
        registry(new TaskCreateCommand(this));
        registry(new TaskCreateToProjectCommand(this));
        registry(new TaskUpdateCommand(this));
        registry(new TaskUpdateToProjectCommand(this));
        registry(new TaskListCommand(this));
        registry(new TaskListToProjectCommand(this));
        registry(new TaskRemoveCommand(this));
        registry(new TaskRemoveToProjectCommand(this));
        registry(new TaskClearCommand(this));
        registry(new TaskClearToProjectCommand(this));
        registry(new TaskAddToProjectCommand(this));
        registry(new ClearAllCommand(this));
        registry(new ListAllCommand(this));
        registry(new HelpCommand(this));
    }
}
