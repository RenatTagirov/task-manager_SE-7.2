package ru.tagirov.tm.repository;

import ru.tagirov.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IRepository <T extends AbstractEntity>{

     T findOne(final String s);

     Collection<T> findAll();

     void persist(final T t);

     T merge(final T t);

     T remove(final String s);

     void removeAll();


}
