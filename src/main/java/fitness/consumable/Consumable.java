package fitness.consumable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Consumable {
    int volume();

    LocalDateTime getDateTime();

    LocalTime getTime();

    LocalDate getDate();
}
