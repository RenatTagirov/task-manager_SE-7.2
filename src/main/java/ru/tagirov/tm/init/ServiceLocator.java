package ru.tagirov.tm.init;

import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.enumeration.Role;
import ru.tagirov.tm.service.IProjectService;
import ru.tagirov.tm.service.ITaskService;
import ru.tagirov.tm.service.IUserService;
import ru.tagirov.tm.util.DateUtil;
import ru.tagirov.tm.util.Md5Util;
import ru.tagirov.tm.util.UUIDUtil;

import java.util.List;

public interface ServiceLocator {

    IProjectService<Project> getIProjectService();

    ITaskService<Task> getITaskService();

    IUserService<User> getIUserService();

    List<AbstractCommand> getCommands();

    Role getRole();

    void setRole(Role role);

    DateUtil getDate();

    Md5Util getMd5();

    UUIDUtil getUUID();

    User getUser();

    void setUser(User user);
}
