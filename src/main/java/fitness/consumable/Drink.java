package fitness.consumable;

import java.time.LocalDateTime;

public final class Drink implements Consumable {
    private final int ml;
    private final LocalDateTime dt;

    public Drink(int ml, LocalDateTime dt) {
        this.ml = ml;
        this.dt = dt;
    }

    @Override
    public int volume() {
        return ml;
    }

    @Override
    public LocalDateTime dateAndTime() {
        return dt;
    }
}