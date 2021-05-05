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
import ru.tagirov.tm.util.TerminalService;

import java.io.IOException;
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

    public static Role role = Role.USER;
    public static User user;
    String str;


    public void start() throws IOException,InstantiationException, IllegalAccessException {
        init();
        System.out.println("***WELCOME TO TASK MANAGER***");
        while (!(str = TerminalService.service()).equalsIgnoreCase("Exit")) {
            if (user == null) {
                for (AbstractCommand tmp : getCommands()) {
                    if (tmp.getName().equalsIgnoreCase(str) && tmp.getRoleCommand().equals("all")) {
                        tmp.execute();
                    }
                }
            } else if (user.getRole().getTitle().equals("user")) {
                for (AbstractCommand tmp : getCommands()) {
                    if (tmp.getName().equalsIgnoreCase(str) && (tmp.getRoleCommand().equals("user") || tmp.getRoleCommand().equals("all"))) {
                        tmp.execute();
                    } else if (tmp.getName().equalsIgnoreCase(str) && tmp.getRoleCommand().equals("admin")) {
                        System.out.println("[THE COMMAND IS NOT VALID!]");
                        System.out.println();
                    }
                }
            } else if (user.getRole().getTitle().equals("admin")) {
                for (AbstractCommand tmp : getCommands()) {
                    if (tmp.getName().equalsIgnoreCase(str)) {
                        tmp.execute();
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
    public Collection<AbstractCommand> getCommands() {
        return commands.values();
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
