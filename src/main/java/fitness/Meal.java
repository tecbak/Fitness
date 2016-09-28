package fitness;

import java.time.LocalDateTime;

final class Meal {
    final int kcal;
    final LocalDateTime dt;

    public Meal(int kcal, LocalDateTime dt) {
        this.kcal = kcal;
        this.dt = dt;
    }
}
