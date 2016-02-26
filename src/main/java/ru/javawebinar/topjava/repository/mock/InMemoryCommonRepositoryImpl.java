package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.CommonRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryCommonRepositoryImpl<T extends BaseEntity> implements CommonRepository<T> {

    private static final LoggerWrapper LOG = LoggerWrapper.get(InMemoryCommonRepositoryImpl.class);
    protected Map<Integer, T> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public T save(T entity) {
        LOG.info("Save:" + entity);
        if(entity.isNew()) {
            entity.setId(counter.incrementAndGet());
        }
        return repository.put(entity.getId(), entity);
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete" + id);
        return (null != repository.remove(id));
    }

    @Override
    public T get(int id) {
        LOG.info("Get" + id);
        return repository.get(id);
    }

    @Override
    public List<T> getAll() {
        LOG.info("Get all");
        return repository.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }


}
