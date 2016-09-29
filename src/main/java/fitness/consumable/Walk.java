package fitness.consumable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class Walk implements Consumable {
    private final int steps;
    private final LocalDateTime dateTime;

    public Walk(int steps, LocalDateTime dateTime) {
        this.steps = steps;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return steps;
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
