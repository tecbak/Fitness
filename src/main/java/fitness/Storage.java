package fitness;

import fitness.consumable.Consumable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Storage {
    private List<Consumable> list = new ArrayList<>();

    void add(Consumable consumable) {
        list.add(consumable);
    }

    int totallyConsumed() {
        int sum = 0;
        for (Consumable consumable : list) {
            sum += consumable.volume();
        }
        return sum;
    }

    int leftToConsumeOnDate(LocalDate date, int dailyNorm) {
        assert (dailyNorm >= 0);

        return dailyNorm - consumedOnDate(date);
    }

    int consumedOnDate(LocalDate date) {
        int sum = 0;
        for (Consumable consumable : list) {
            if (consumable.getDate().equals(date)) {
                sum += consumable.volume();
            }
        }
        return sum;
    }
}
