package fitness.consumable;

import java.time.LocalDateTime;

public final class Meal implements Consumable {
    private final int kcal;
    private final LocalDateTime dt;

    public Meal(int kcal, LocalDateTime dt) {
        this.kcal = kcal;
        this.dt = dt;
    }

    @Override
    public int volume() {
        return kcal;
    }

    @Override
    public LocalDateTime dateAndTime() {
        return dt;
    }
}
