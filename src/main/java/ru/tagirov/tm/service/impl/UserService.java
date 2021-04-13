package ru.tagirov.tm.service.impl;

import ru.tagirov.tm.entity.Project;
import ru.tagirov.tm.entity.Task;
import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.repository.AbstractRepository;
import ru.tagirov.tm.repository.ITaskRepository;
import ru.tagirov.tm.repository.IUserRepository;
import ru.tagirov.tm.repository.impl.UserRepository;
import ru.tagirov.tm.service.AbstractService;
import ru.tagirov.tm.service.IProjectService;
import ru.tagirov.tm.service.IUserService;

import java.util.Map;

public class UserService extends AbstractService<User> implements IUserService<User> {

    private IUserRepository<User> userRepository;

    public UserService(final IUserRepository userRepository){
        this.userRepository = userRepository;
    }
}
