package fitness;

import java.time.LocalDateTime;
import java.util.*;

public class Fitness {
    private List<Drink> drinks = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();

    /*Eat methods*/
    public void eat(int kcal, LocalDateTime dt) {
        Meal meal = new Meal(kcal, dt);
        meals.add(meal);
    }

    public int eaten() {
        int sum = 0;
        for (Meal meal : meals) {
            sum += meal.kcal;
        }
        return sum;
    }

    /*Drink methods*/
    public void drink(int ml, LocalDateTime dt) {
        Drink drink = new Drink(ml, dt);
        drinks.add(drink);
    }

    public int drunk() {
        int sum = 0;
        for (Drink drink : drinks) {
            sum += drink.ml;
        }
        return sum;
    }
}
