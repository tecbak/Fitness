package fitness.consumable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class Meal implements Consumable {
    private final int kcal;
    private final LocalDateTime dateTime;

    public Meal(int kcal, LocalDateTime dateTime) {
        this.kcal = kcal;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return kcal;
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
