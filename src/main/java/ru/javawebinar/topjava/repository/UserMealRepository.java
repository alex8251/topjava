package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository extends CommonRepository<UserMeal>{
//    UserMeal save(UserMeal userMeal);
//
//    void delete(int id);
//
//    UserMeal get(int id);
//
    List<UserMeal> getByUserId(int userId);
//
//    Collection<UserMeal> getAll();
}
