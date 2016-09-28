package fitness;

import java.time.LocalDateTime;
import java.util.*;

public class Fitness {
    private List<Drink> drinks = new ArrayList<>();


    public void eat(int kcal, LocalDateTime dt) {

    }

    public int eaten() {
        return 0;
    }

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
