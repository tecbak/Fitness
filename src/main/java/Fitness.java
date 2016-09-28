import java.time.LocalDateTime;
import java.util.*;

public class Fitness {
    private List<Drink> drinks = new ArrayList<>();

    private static class Drink {
        private int ml;
        private LocalDateTime dt;

        public Drink(int ml, LocalDateTime dt) {
            this.ml = ml;
            this.dt = dt;
        }
    }

    public void drinkWater(int ml, LocalDateTime dt) {
        Drink drink = new Drink(ml, dt);
        drinks.add(drink);
    }

    public int drunkWater() {
        int sum = 0;
        for (Drink drink : drinks) {
            sum += drink.ml;
        }
        return sum;
    }
}
