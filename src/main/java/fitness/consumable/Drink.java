package fitness.consumable;

import java.time.LocalDateTime;

public final class Drink implements Consumable {
    private final int ml;
    private final LocalDateTime dateTime;

    public Drink(int ml, LocalDateTime dateTime) {
        this.ml = ml;
        this.dateTime = dateTime;
    }

    @Override
    public int volume() {
        return ml;
    }

    @Override
    public LocalDateTime dateAndTime() {
        return dateTime;
    }
}