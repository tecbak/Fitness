package fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Consumable {
    private final int volume;
    private final LocalDateTime dateTime;

    public Consumable(int volume, LocalDateTime dateTime) {
        this.volume = volume;
        this.dateTime = dateTime;
    }


    public int volume() {
        return volume;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }


    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }
}
