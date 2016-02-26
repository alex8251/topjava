package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl extends InMemoryCommonRepositoryImpl<User> implements UserRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(InMemoryUserRepositoryImpl.class);
//    private Map<Integer, User> repository = new ConcurrentHashMap<>();
//    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.USER_LIST.forEach(this::save);
    }

//    @Override
//    public boolean delete(int id) {
//        LOG.info("delete " + id);
//        return (null != repository.remove(id));
//    }
//
//    @Override
//    public User save(User user) {
//        LOG.info("save " + user);
//
//        if(user.isNew()) {
//            user.setId(counter.incrementAndGet());
//        }
//        return repository.put(user.getId(), user);
//    }
//
//    @Override
//    public User get(int id) {
//        LOG.info("get " + id);
//        return repository.get(id);
//    }
//
//    @Override
//    public List<User> getAll() {
//        LOG.info("getAll");
//        return repository.values().stream()
//                .sorted()
//                .collect(Collectors.toList());
//    }
//
    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        List<User> usersList = repository.values().stream()
                .filter(user -> user.getEmail() == email)
                .collect(Collectors.toList());
        if (!usersList.isEmpty()) {
            return usersList.get(0);
        } else {
            return null;
        }
    }
}
