package fitness;

import fitness.consumable.Consumable;
import fitness.consumable.Drink;
import fitness.consumable.Meal;

import java.time.LocalDateTime;
import java.util.*;

public class Fitness {
    private List<Drink> drinks = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();

    public void eat(int kcal, LocalDateTime dt) {
        Meal meal = new Meal(kcal, dt);
        meals.add(meal);
    }

    public void drink(int ml, LocalDateTime dt) {
        Drink drink = new Drink(ml, dt);
        drinks.add(drink);
    }

    public int eaten() {
        return volume(meals);
    }

    public int drunk() {
        return volume(drinks);
    }

    private int volume(List<? extends Consumable> consumables) {
        int sum = 0;
        for (Consumable consumable : consumables) {
            sum += consumable.volume();
        }
        return sum;
    }
}
