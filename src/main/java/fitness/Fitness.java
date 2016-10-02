package fitness;

import fitness.consumable.ConsumableUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fitness {
    private Storage drinks = new Storage();
    private Storage meals = new Storage();
    private Storage walks = new Storage();
    private int waterDailyNorm;
    private int mealDailyNorm;
    private int walkDailyNorm;
    private List<Routine> routines = new ArrayList<>();

    /*Daily norms getters and setters*/
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

    /*Consume*/
    public void eat(int kcal, LocalDateTime dt) {
        ConsumableUnit meal = new ConsumableUnit(kcal, dt);
        meals.add(meal);
    }

    public void drink(int ml, LocalDateTime dt) {
        ConsumableUnit drink = new ConsumableUnit(ml, dt);
        drinks.add(drink);
    }

    public void walk(int steps, LocalDateTime dt) {
        ConsumableUnit walk = new ConsumableUnit(steps, dt);
        walks.add(walk);
    }

    /*Total statistics*/
    public int eaten() {
        return meals.totallyConsumed();
    }

    public int drunk() {
        return drinks.totallyConsumed();
    }

    public int walked() {
        return walks.totallyConsumed();
    }

    /*Statistics on date*/
    public int leftToDrinkOnDate(LocalDate date) {
        return drinks.leftToConsumeOnDate(date, waterDailyNorm);
    }

    public int leftToEatOnDate(LocalDate date) {
        return meals.leftToConsumeOnDate(date, mealDailyNorm);
    }

    public int leftToWalkOnDate(LocalDate date) {
        return walks.leftToConsumeOnDate(date, walkDailyNorm);
    }

    public int drunkOnDate(LocalDate date) {
        return drinks.consumedOnDate(date);
    }

    public int eatenOnDate(LocalDate date) {
        return meals.consumedOnDate(date);
    }

    public int walkedOnDate(LocalDate date) {
        return walks.consumedOnDate(date);
    }

    public int drunkRateOnDate(LocalDate date) {
        return drinks.rateOnDate(date, waterDailyNorm);
    }

    public int eatenRateOnDate(LocalDate date) {
        return meals.rateOnDate(date, mealDailyNorm);
    }

    public int walkedRateOnDate(LocalDate date) {
        return walks.rateOnDate(date, walkDailyNorm);
    }

    /*Statistics for period*/
    public int drunkRateForPeriod(LocalDate start, LocalDate end) {
        return drinks.rateForPeriod(start, end, waterDailyNorm);
    }

    public int eatenRateForPeriod(LocalDate start, LocalDate end) {
        return meals.rateForPeriod(start, end, mealDailyNorm);
    }

    public int walkedRateForPeriod(LocalDate start, LocalDate end) {
        return walks.rateForPeriod(start, end, walkDailyNorm);
    }

    /*Routines*/
    public void addRoutine(LocalTime time, String message) {
        routines.add(new Routine(time, message));
    }

    public String nextRoutine(LocalTime time) {
        Collections.sort(routines);
        for (Routine routine : routines) {
            if (routine.getTime().compareTo(time) >= 0) {
                return routine.toString();
            }
        }
        return "Nothing left to do today";
    }
}