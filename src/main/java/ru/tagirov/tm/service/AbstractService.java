package ru.tagirov.tm.service;

import ru.tagirov.tm.entity.AbstractEntity;
import ru.tagirov.tm.repository.AbstractRepository;
import ru.tagirov.tm.repository.IRepository;
import ru.tagirov.tm.repository.impl.TaskRepository;

import java.util.Collection;

public abstract class AbstractService <T extends AbstractEntity> implements IService<T> {

    IRepository<T> abstractRepository;

    public AbstractService() {
    }

    public AbstractService(IRepository<T> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    @Override
    public T findOne(String s) {
        return abstractRepository.findOne(s);
    }

    @Override
    public Collection<T> findAll() {
        return abstractRepository.findAll();
    }

    @Override
    public void persist(T t) {
        abstractRepository.persist(t);
    }

    @Override
    public T merge(T t) {
        return abstractRepository.merge(t);
    }

    @Override
    public T remove(String s) {
        return abstractRepository.remove(s);
    }

    @Override
    public void removeAll() {
        abstractRepository.removeAll();
    }
}
