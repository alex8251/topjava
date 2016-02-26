package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.User;

import java.util.List;

public interface CommonRepository<T> {
    T save(T entity);

    // false if not found
    boolean delete(int id);

    // null if not found
    T get(int id);

    List<T> getAll();

}
