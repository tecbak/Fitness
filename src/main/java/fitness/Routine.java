package fitness;

import java.time.LocalTime;

class Routine implements Comparable<Routine> {
    private final String message;
    private final LocalTime time;

    Routine(LocalTime time, String message) {
        this.message = message;
        this.time = time;
    }

    String getMessage() {
        return message;
    }

    LocalTime getTime() {
        return time;
    }

    @Override
    public int compareTo(Routine o) {
        LocalTime time = o.getTime();
        return this.time.compareTo(time);
    }

    @Override
    public String toString() {
        return message + " @ " + time.toString();
    }
}
