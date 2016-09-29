package fitness.consumable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

public final class Drink implements Consumable {
    private final int ml;
    private final LocalDateTime dateTime;

    public static class DrinkComparator implements Comparator<Drink> {
        @Override
        public int compare(Drink o1, Drink o2) {
            return 0;
        }
    }


    public Drink(int ml, LocalDateTime dateTime) {
        this.ml = ml;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return ml;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }
}