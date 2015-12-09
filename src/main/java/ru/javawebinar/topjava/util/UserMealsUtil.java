package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.model.UserMealPerDay;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field

        Map<LocalDate, UserMealPerDay> mealsPerDayMap = new HashMap<>();

        LocalDate mealDate;

        UserMealPerDay mealPerDay;

        for (UserMeal userMeal : mealList) {

            mealDate = userMeal.getDateTime().toLocalDate();

            if (mealsPerDayMap.containsKey(mealDate)) {

                mealsPerDayMap.get(mealDate).addMeal(userMeal);

            } else {

                mealPerDay = new UserMealPerDay();

                mealPerDay.addMeal(userMeal);

                mealsPerDayMap.put(mealDate, mealPerDay);

            }

        }

        List<UserMealWithExceed> userMealWithExceedList = new ArrayList<>();

        for(Map.Entry<LocalDate, UserMealPerDay> entry : mealsPerDayMap.entrySet()) {

            int actualCalories = entry.getValue().getTotalCalories();

            boolean exceed = false;

            if(actualCalories > caloriesPerDay) {

                exceed = true;

            }

            List<UserMeal> filteredMealList = entry.getValue().getMeal(startTime, endTime);

            for(UserMeal userMeal : filteredMealList) {

                userMealWithExceedList.add(new UserMealWithExceed(userMeal.getDateTime(),userMeal.getDescription()
                                                                    ,userMeal.getCalories(), exceed));

            }
        }

        return userMealWithExceedList;

    }

}
