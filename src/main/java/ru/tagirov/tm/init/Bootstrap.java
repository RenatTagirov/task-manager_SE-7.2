package ru.tagirov.tm.init;

import ru.tagirov.tm.command.*;
import ru.tagirov.tm.command.AllCommand.ExitCommand;
import ru.tagirov.tm.command.AllCommand.HelpCommand;
import ru.tagirov.tm.command.AllCommand.LoginCommand;
import ru.tagirov.tm.command.AllCommand.RegistrationCommand;
import ru.tagirov.tm.command.adminCommand.*;
import ru.tagirov.tm.command.projectCommand.*;
import ru.tagirov.tm.command.taskCommand.*;
import ru.tagirov.tm.command.userCommand.*;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.enumeration.Role;
import ru.tagirov.tm.repository.ProjectRepository;
import ru.tagirov.tm.repository.TaskRepository;
import ru.tagirov.tm.repository.UserRepository;
import ru.tagirov.tm.service.ProjectService;
import ru.tagirov.tm.service.TaskService;
import ru.tagirov.tm.service.UserService;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.Md5Util;
import ru.tagirov.tm.util.UUIDUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Bootstrap {

    public Map<String, AbstractCommand> commands = new LinkedHashMap<>();
    public UserRepository userRepository = new UserRepository();
    public UserService userService = new UserService(userRepository);
    public ProjectRepository projectRepository = new ProjectRepository();
    public ProjectService projectService = new ProjectService(projectRepository);
    public TaskRepository taskRepository = new TaskRepository();
    public TaskService taskService = new TaskService(taskRepository);
    public Md5Util md5 = new Md5Util();
    public DateUtil getDate = new DateUtil();
    public UUIDUtil uuid = new UUIDUtil();
    public Role role = Role.USER;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str;

    public User user;

    public void start() throws IOException, NoSuchAlgorithmException {
        init();
        System.out.println("***WELCOME TO TASK MANAGER***");
        while (!(str = reader.readLine()).equalsIgnoreCase("Exit")) {
            if (user == null) {
                for (Map.Entry<String, AbstractCommand> tmp : commands.entrySet()) {
                    if (tmp.getKey().equalsIgnoreCase(str) && tmp.getValue().getRoleCommand().equals("all")) {
                        tmp.getValue().execute();
                    }
                }
            } else if (user.getRole().getTitle().equals("user")) {
                for (Map.Entry<String, AbstractCommand> tmp : commands.entrySet()) {
                    if (tmp.getKey().equalsIgnoreCase(str) && (tmp.getValue().getRoleCommand().equals("user") || tmp.getValue().getRoleCommand().equals("all"))) {
                        tmp.getValue().execute();
                    } else if (tmp.getKey().equalsIgnoreCase(str) && tmp.getValue().getRoleCommand().equals("admin")) {
                        System.out.println("[THE COMMAND IS NOT VALID!]");
                        System.out.println();
                    }
                }
            } else if (user.getRole().getTitle().equals("admin")) {
                for (Map.Entry<String, AbstractCommand> tmp : commands.entrySet()) {
                    if (tmp.getKey().equalsIgnoreCase(str)) {
                        tmp.getValue().execute();
                    }
                }
            } else {
                System.out.println("[THE COMMAND IS NOT VALID!]");
                System.out.println("[YOU ARE LOGGER OUT OF YOUR ACCOUNT!]");
                System.out.println();
            }
        }
    }

    private void registry(final AbstractCommand command) {
        final String commandName = command.getName();
        final String commandDescription = command.getDescription();

        if (commandName == null || commandName.isEmpty()) {
            System.out.println("Command don't registration!");
        }
        if (commandDescription == null || commandDescription.isEmpty()) {
            System.out.println("Command don't registration!");
        }
        commands.put(commandName, command);
    }

    private void init() throws NoSuchAlgorithmException {
        registry(new RegistrationCommand(this));
        registry(new LoginCommand(this));
        registry(new ExitCommand(this));
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
        registry(new UserClearAllCommand(this));
        registry(new UserListAllCommand(this));
        registry(new HelpCommand(this));
    }
}
//    project create
//    project list
//    project update
//    project remove
//    project clear
//
//    task create
//    task create to project
//    task list
//    task list to project
//    task update
//    task update to project
//    task remove
//    task remove to project
//    task clear
//    task clear to project
//    task add to project
//
//    show profile
//    update profile
//    update password
//    list all
//    clear all
//
//    show user
//    show all users
//    remove user
//    show projects user
//    show tasks user
//    show tasks to project user

//    registration
//    login
//    exit - account
//    help
