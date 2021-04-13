package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.AbstractEntity;

import java.util.Collection;

public interface ITaskService <T extends AbstractEntity> extends IService<T>{

    @Override
    T findOne(final String s);

    @Override
    Collection<T> findAll();

    @Override
    void persist(final T t);

    @Override
    T merge(final T t);

    @Override
    T remove(final String s);

    @Override
    void removeAll();
}
