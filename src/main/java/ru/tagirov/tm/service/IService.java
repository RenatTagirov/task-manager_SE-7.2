package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IService<T extends AbstractEntity>{

    T findOne(final String s);

    Collection<T> findAll();

    void persist(final T t);

    T merge(final T t);

    T remove(final String s);

    void removeAll();
}
