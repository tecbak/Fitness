package fitness;

import java.time.LocalDateTime;

final class Drink {
    final int ml;
    final LocalDateTime dt;

    public Drink(int ml, LocalDateTime dt) {
        this.ml = ml;
        this.dt = dt;
    }
}