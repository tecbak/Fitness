package fitness;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TotalStatisticsTest {
    private Fitness fitness;
    private int[] volume;
    private LocalDateTime dateTime;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();
        volume = new int[]{200, 300};
        dateTime = LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.NOON);
    }

    @Test
    public void testTotallyDrunk() throws Exception {
        fitness.drink(volume[0], dateTime);
        fitness.drink(volume[1], dateTime);

        int expected = volume[0] + volume[1];
        int actual = fitness.drunk();

        assertThat(actual, is(expected));
    }

    @Test
    public void testTotallyEaten() throws Exception {
        fitness.eat(volume[0], dateTime);
        fitness.eat(volume[1], dateTime);

        int expected = volume[0] + volume[1];
        int actual = fitness.eaten();

        assertThat(actual, is(expected));
    }

    @Test
    public void testTotallyWalked() throws Exception {
        final int steps0 = 1000;
        final int steps1 = 555;

        fitness.walk(steps0, dateTime);
        fitness.walk(steps1, dateTime);

        int expected = steps0 + steps1;
        int actual = fitness.walked();

        assertThat(actual, is(expected));
    }
}