package fitness;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FitnessTest {
    private Fitness fitness;
    private LocalDateTime dt;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();
        dt = LocalDateTime.now();
    }

    @Test
    public void drink() throws Exception {
        final int ml0 = 200;
        final int ml1 = 300;

        fitness.drink(ml0, dt);
        fitness.drink(ml1, dt);

        int expected = ml0 + ml1;
        int actual = fitness.drunk();

        assertThat(actual, is(expected));
    }

    @Test
    public void eat() throws Exception {
        final int kcal0 = 500;
        final int kcal1 = 400;

        fitness.eat(kcal0, dt);
        fitness.eat(kcal1, dt);

        int expected = kcal0 + kcal1;
        int actual = fitness.eaten();

        assertThat(actual, is(expected));
    }

    @Test
    public void walk() throws Exception {
        final int steps0 = 1000;
        final int steps1 = 555;

        fitness.walk(steps0, dt);
        fitness.walk(steps1, dt);

        int expected = steps0 + steps1;
        int actual = fitness.walked();

        assertThat(actual, is(expected));
    }
}