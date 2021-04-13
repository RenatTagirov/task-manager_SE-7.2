package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.AbstractEntity;

import java.util.Collection;

public interface ITaskRepository<T extends AbstractEntity> extends IRepository<T> {

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
