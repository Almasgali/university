package ru.university.repository;

import java.util.List;

public interface Repository<T> {

    void loadAll();

    void saveAll();

    void add(T entity);

    List<T> list();
}
