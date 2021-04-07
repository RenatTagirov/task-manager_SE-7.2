package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.User;
import ru.tagirov.tm.repository.UserRepository;

import java.util.Map;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Map<String, User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(final User user){
        return userRepository.findOne(user);
    }

    public void persist(final User user){
        userRepository.persist(user);
    }

    public User merge(final User user){
        userRepository.merge(user);
        return userRepository.merge(user);
    }

    public void remove(final User user){
        userRepository.remove(user);
    }

    public void removeAll(){
        userRepository.removeAll();
    }
}
