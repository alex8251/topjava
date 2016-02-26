package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */
public class InMemoryUserMealRepositoryImpl extends InMemoryCommonRepositoryImpl<UserMeal> implements UserMealRepository {
//    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
//    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::save);
    }

    @Override
    public List<UserMeal> getByUserId(int userId) {
        return repository.values().stream()
                .filter(um -> um.getUserId() == userId)
                .sorted((um1, um2) -> um2.getDateTime().compareTo(um1.getDateTime()))
                .collect(Collectors.toList());
    }

//    @Override
//    public UserMeal save(UserMeal userMeal) {
//        if (userMeal.isNew()) {
//            userMeal.setId(counter.incrementAndGet());
//        }
//        return repository.put(userMeal.getId(), userMeal);
//    }
//
//    @Override
//    public void delete(int id) {
//        repository.remove(id);
//    }
//
//    @Override
//    public UserMeal get(int id) {
//        return repository.get(id);
//    }
//
//    @Override
//    public Collection<UserMeal> getAll() {
//        return repository.values().stream()
//                .sorted((um1, um2) -> um2.getDateTime().compareTo(um1.getDateTime()))
//                .collect(Collectors.toList());
//    }
}

