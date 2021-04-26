package ru.tagirov.tm.init;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.enumeration.Role;
import ru.tagirov.tm.service.IProjectService;
import ru.tagirov.tm.service.ITaskService;
import ru.tagirov.tm.service.IUserService;

import java.util.Collection;
import java.util.List;

public interface ServiceLocator {

    IProjectService<Project> getIProjectService();

    ITaskService<Task> getITaskService();

    IUserService<User> getIUserService();

    Collection<AbstractCommand> getCommands();
}
