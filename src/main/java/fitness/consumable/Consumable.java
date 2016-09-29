package fitness.consumable;

import java.time.LocalDateTime;

public interface Consumable {
    int volume();

    LocalDateTime getDateTime();
}
