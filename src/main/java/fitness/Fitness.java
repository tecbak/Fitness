package fitness;

import fitness.consumable.Consumable;
import fitness.consumable.Drink;
import fitness.consumable.Meal;
import fitness.consumable.Walk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Fitness {
    private List<Drink> drinks = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();
    private List<Walk> walks = new ArrayList<>();
    private int waterDailyNorm;
    private int mealDailyNorm;
    private int walkDailyNorm;

    public void eat(int kcal, LocalDateTime dt) {
        Meal meal = new Meal(kcal, dt);
        meals.add(meal);
    }

    public void drink(int ml, LocalDateTime dt) {
        Drink drink = new Drink(ml, dt);
        drinks.add(drink);
    }

    public void walk(int steps, LocalDateTime dt) {
        Walk walk = new Walk(steps, dt);
        walks.add(walk);
    }

    public int eaten() {
        return volume(meals);
    }

    public int drunk() {
        return volume(drinks);
    }

    public int walked() {
        return volume(walks);
    }

    private int volume(List<? extends Consumable> consumables) {
        int sum = 0;
        for (Consumable consumable : consumables) {
            sum += consumable.volume();
        }
        return sum;
    }

    public void setWaterDailyNorm(int waterDailyNorm) {
        this.waterDailyNorm = waterDailyNorm;
    }

    public int getWaterDailyNorm() {
        return waterDailyNorm;
    }

    public void setMealDailyNorm(int mealDailyNorm) {
        this.mealDailyNorm = mealDailyNorm;
    }

    public int getMealDailyNorm() {
        return mealDailyNorm;
    }

    public void setWalkDailyNorm(int walkDailyNorm) {
        this.walkDailyNorm = walkDailyNorm;
    }

    public int getWalkDailyNorm() {
        return walkDailyNorm;
    }

    public int waterLeft(LocalDate date) {
        int drunk = 0;

        for (Drink drink : drinks) {
            if (drink.getDate().equals(date)) {
                drunk += drink.volume();
            }
        }

        return waterDailyNorm - drunk;
    }
}
