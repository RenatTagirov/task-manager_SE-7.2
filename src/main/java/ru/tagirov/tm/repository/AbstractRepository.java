package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.AbstractEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRepository <T extends AbstractEntity> implements IRepository<T>{

    Map<String, T> map = new LinkedHashMap<>();

    @Override
    public T findOne(final String s) {
        return map.get(s);
    }

    @Override
    public Collection<T> findAll() {
        return map.values();
    }

    @Override
    public void persist(T t) {
        map.put(t.getId(), t);
    }

    @Override
    public T merge(T t) {
        return map.put(t.getId(), t);
    }

    @Override
    public T remove(String s) {
        return map.remove(s);
    }

    @Override
    public void removeAll() {
        map.clear();
    }
}
