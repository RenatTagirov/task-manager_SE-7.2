package ru.tagirov.tm.init;

import org.reflections.Reflections;
import ru.tagirov.tm.command.*;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.enumeration.Role;
import ru.tagirov.tm.repository.IProjectRepository;
import ru.tagirov.tm.repository.ITaskRepository;
import ru.tagirov.tm.repository.IUserRepository;
import ru.tagirov.tm.repository.impl.ProjectRepository;
import ru.tagirov.tm.repository.impl.TaskRepository;
import ru.tagirov.tm.repository.impl.UserRepository;
import ru.tagirov.tm.service.IProjectService;
import ru.tagirov.tm.service.ITaskService;
import ru.tagirov.tm.service.IUserService;
import ru.tagirov.tm.service.impl.ProjectService;
import ru.tagirov.tm.service.impl.TaskService;
import ru.tagirov.tm.service.impl.UserService;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.Md5Util;
import ru.tagirov.tm.util.UUIDUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bootstrap implements ServiceLocator{

    public Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    private final IProjectRepository<Project> iProjectRepository = new ProjectRepository();
    private final ITaskRepository<Task> iTaskRepository = new TaskRepository();
    private final IUserRepository<User> iUserRepository = new UserRepository();
    private final IProjectService<Project> projectService = new ProjectService(iProjectRepository);
    private final ITaskService<Task> taskService = new TaskService(iTaskRepository);
    private final IUserService<User> userService = new UserService(iUserRepository);
    private final Set<Class<? extends AbstractCommand>> commandClasses = getAbstractCommandClasses();

    private Set<Class<? extends AbstractCommand>> getAbstractCommandClasses() {
        return new Reflections("ru.tagirov.tm").getSubTypesOf(AbstractCommand.class);
    }

    public Md5Util md5 = new Md5Util();
    public DateUtil date = new DateUtil();
    public UUIDUtil uuid = new UUIDUtil();
    public Role role = Role.USER;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str;

    public User user;

    public void start() throws IOException,InstantiationException, IllegalAccessException {
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
        command.setServiceLocator(this);
        commands.put(commandName, command);
    }

    private void init() throws IllegalAccessException, InstantiationException {
        for (final Class<? extends AbstractCommand> abstractClass : commandClasses) {
            registry(abstractClass.newInstance());
        }
    }

    @Override
    public IProjectService<Project> getIProjectService() {
        return projectService;
    }

    @Override
    public ITaskService<Task> getITaskService() {
        return taskService;
    }

    @Override
    public IUserService<User> getIUserService() {
        return userService;
    }

    @Override
    public List<AbstractCommand> getCommands() {
        return (List<AbstractCommand>) commands.values();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public DateUtil getDate() {
        return date;
    }

    @Override
    public Md5Util getMd5() {
        return md5;
    }

    @Override
    public UUIDUtil getUUID() {
        return uuid;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
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
