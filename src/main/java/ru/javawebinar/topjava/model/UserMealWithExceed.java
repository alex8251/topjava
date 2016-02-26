package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMealWithExceed extends UserMeal{
    protected final boolean exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, Integer userId, boolean exceed) {
        this(null, dateTime, description, calories, userId, exceed);
    }

    public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, int calories, Integer userId, boolean exceed) {
        super(id, dateTime, description, calories, userId);
        this.exceed = exceed;
    }

    public boolean isExceed() {
        return exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "id=" + id +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
