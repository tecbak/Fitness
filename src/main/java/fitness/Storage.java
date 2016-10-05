package fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

class Storage {
    private Map<LocalDate, List<Consumable>> registry = new HashMap<>();

    void add(int volume, LocalDateTime dateTime) {
        Consumable consumable = new Consumable(volume, dateTime);
        LocalDate date = dateTime.toLocalDate();
        List<Consumable> consumables = getConsumablesByDate(date);
        consumables.add(consumable);
    }

    private List<Consumable> getConsumablesByDate(LocalDate date) {
        if (registry.containsKey(date)) {
            return registry.get(date);
        } else {
            List<Consumable> consumables = new ArrayList<>();
            registry.put(date, consumables);
            return consumables;
        }
    }

    int totallyConsumed() {
        int sum = 0;
        for (LocalDate date : registry.keySet()) {
            sum += consumedOnDate(date);
        }
        return sum;
    }

    int consumedOnDate(LocalDate date) {
        int sum = 0;
        for (Consumable consumable : registry.get(date)) {
            sum += consumable.volume();
        }
        return sum;
    }

    int leftToConsumeOnDate(LocalDate date, int dailyNorm) {
        checkDailyNorm(dailyNorm);
        return dailyNorm - consumedOnDate(date);
    }

    int rateOnDate(LocalDate date, int dailyNorm) {
        checkDailyNorm(dailyNorm);
        return consumedOnDate(date) * 100 / dailyNorm;
    }

    int rateForPeriod(LocalDate start, LocalDate end, int dailyNorm) {
        checkDailyNorm(dailyNorm);
        checkStartAndEnd(start, end);

        List<Integer> rates = getDailyRates(start, end, dailyNorm);
        return getMedian(rates);
    }

    private List<Integer> getDailyRates(LocalDate start, LocalDate end, int dailyNorm) {
        List<Integer> rates = new ArrayList<>();
        for (LocalDate date = start; date.compareTo(end) <= 0; date = date.plusDays(1)) {
            int rate = rateOnDate(date, dailyNorm);
            rates.add(rate);
        }
        return rates;
    }

    private int getMedian(List<Integer> list) {
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2);
        } else {
            int a = list.get(size / 2);
            int b = list.get(size / 2 - 1);
            return (a + b) / 2;
        }
    }

    private void checkStartAndEnd(LocalDate start, LocalDate end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException("End date must be either greater than or equal to the start date");
    }

    private void checkDailyNorm(int dailyNorm) {
        if (dailyNorm < 0)
            throw new IllegalArgumentException("Daily norm must be more then 0");
    }
}
