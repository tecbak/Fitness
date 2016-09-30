package fitness.consumable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

public class ConsumableUnit implements Consumable {
    private final int volume;
    private final LocalDateTime dateTime;

    public ConsumableUnit(int volume, LocalDateTime dateTime) {
        this.volume = volume;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return volume;
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
