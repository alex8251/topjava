package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMeal extends BaseEntity implements Comparable<UserMeal>{
    //protected Integer id;

    protected final Integer userId;

    protected final LocalDateTime dateTime;

    protected final String description;

    protected final int calories;

    public UserMeal(LocalDateTime dateTime, String description, int calories, Integer userId) {
        this(null, dateTime, description, calories, userId);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public Integer getUserId() {
        return userId;
    }

//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public boolean isNew() {
//        return id == null;
//    }
//
    @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }

    @Override
    public int compareTo(UserMeal userMeal) {
        return this.getDateTime().compareTo(userMeal.getDateTime());
    }

}
