package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.User;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserRepository {
    Map<String, User> userMap = new LinkedHashMap<>();

    public Map<String, User> findAll(){
        return userMap;
    }

    public User findOne(final User user){
        return userMap.get(user.getUserId());
    }

    public void persist(final User user){
        userMap.put(user.getUserId(), user);
    }

    public User merge(final User user){
        userMap.put(user.getUserId(), user);
        return userMap.get(user.getUserId());
    }

    public void remove(final User user){
        userMap.remove(user.getUserId());

    }

    public void removeAll(){
        userMap.clear();
    }
}
