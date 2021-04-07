package ru.tagirov.tm;

import ru.tagirov.tm.Command.*;
import ru.tagirov.tm.Command.adminCommand.*;
import ru.tagirov.tm.Command.projectCommand.*;
import ru.tagirov.tm.Command.taskCommand.*;
import ru.tagirov.tm.Command.userCommand.*;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.repository.ProjectRepository;
import ru.tagirov.tm.repository.TaskRepository;
import ru.tagirov.tm.repository.UserRepository;
import ru.tagirov.tm.service.ProjectService;
import ru.tagirov.tm.service.TaskService;
import ru.tagirov.tm.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bootstrap {

    public Map<String, AbstractCommand> commands = new LinkedHashMap<>();
    public UserRepository userRepository = new UserRepository();
    public UserService userService = new UserService(userRepository);
    public ProjectRepository projectRepository = new ProjectRepository();
    public ProjectService projectService = new ProjectService(projectRepository);
    public TaskRepository taskRepository = new TaskRepository();
    public TaskService taskService = new TaskService(taskRepository);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str;
    public User user;
    public User admin;
    public String userId = null;

    public void start() throws IOException {
        init();
        System.out.println("***WELCOME TO TASK MANAGER***");
        while (!(str = reader.readLine()).equalsIgnoreCase("Exit")){
            if(str.equals("login")){
                for(Map.Entry<String, AbstractCommand> tmp : commands.entrySet()){
                    if (tmp.getKey().equalsIgnoreCase(str)){
                        tmp.getValue().execute();
                    }
                }
            }else if(str.equals("registration")){
                for(Map.Entry<String, AbstractCommand> tmp : commands.entrySet()){
                    if (tmp.getKey().equalsIgnoreCase(str)){
                        tmp.getValue().execute();
                    }
                }
            }else if(user != null){
                for(Map.Entry<String, AbstractCommand> tmp : commands.entrySet()){
                    if (tmp.getKey().equalsIgnoreCase(str) && tmp.getValue().getDisplayName().equals("user")){
                        tmp.getValue().execute();
                    }else if (tmp.getKey().equalsIgnoreCase(str) && tmp.getValue().getDisplayName().equals("admin")){
                        System.out.println("[THE COMMAND IS NOT VALID!]");
                        System.out.println();
                    }
                }
            }else if(admin != null){
                for(Map.Entry<String, AbstractCommand> tmp : commands.entrySet()){
                    if (tmp.getKey().equalsIgnoreCase(str)){
                        tmp.getValue().execute();
                    }
                }
            }else{
                System.out.println("[THE COMMAND IS NOT VALID!]");
                System.out.println("[YOU ARE LOGGER OUT OF YOUR ACCOUNT!]");
                System.out.println();
            }
        }
    }

    private void registry(final AbstractCommand command){
        final String commandName = command.getName();
        final String commandDescription = command.getDescription();

        if (commandName == null || commandName.isEmpty()){
            System.out.println("Command don't registration!");
        }
        if (commandDescription == null || commandDescription.isEmpty()){
            System.out.println("Command don't registration!");
        }
        commands.put(commandName, command);
    }

    private void init(){
        registry(new UserRegistrationCommand(this));
        registry(new UserLoginCommand(this));
        registry(new UserExitCommand(this));
        registry(new UserPasswordUpdateCommand(this));
        registry(new UserUpdateProfileCommand(this));
        registry(new UserShowProfileCommand(this));
        registry(new AdminShowUserCommand(this));
        registry(new AdminShowAllUsersCommand(this));
        registry(new AdminRemoveToUserCommand(this));
        registry(new AdminShowProjectsToUserCommand(this));
        registry(new AdminShowTaskToUserCommand(this));
        registry(new AdminShowTaskToProjectToUserCommand(this));
        registry(new UserPasswordUpdateCommand(this));
        registry(new UserUpdateProfileCommand(this));
        registry(new UserShowProfileCommand(this));
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
