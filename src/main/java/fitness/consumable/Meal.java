package fitness.consumable;

import java.time.LocalDateTime;

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
    public LocalDateTime dateAndTime() {
        return dateTime;
    }
}
