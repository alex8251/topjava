package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** class-helper
 * store all meals of user by day and calculate total amount of calories
 * meals are stored in Map with LocalTime as key and UserMeal as value
 */

public class UserMealPerDay {

    int totalCalories;

    Map<LocalTime, UserMeal> mealMap;

    public UserMealPerDay() {

        totalCalories = 0;

        mealMap = new HashMap<>();

    }
    // add meal to Map and calculate calories
    public void addMeal(UserMeal userMeal) {

        totalCalories += userMeal.getCalories();

        LocalTime key = userMeal.getDateTime().toLocalTime();

        mealMap.put(key, userMeal);

    }
    // return total amount of calories by day
    public int getTotalCalories() {

        return totalCalories;

    }
    // return List of UserMeals between startTime and endTime
    public List<UserMeal> getMeal(LocalTime startTime, LocalTime endTime) {

        ArrayList<UserMeal> mealList = new ArrayList<>();

        for (LocalTime key : mealMap.keySet()) {

            if (TimeUtil.isBetween(key, startTime, endTime)) {

                mealList.add(mealMap.get(key));
            }
        }

        return  mealList;

    }
}