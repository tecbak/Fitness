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
        final int ml = 200;

        fitness.drink(ml, dt);
        int drunk = fitness.drunk();

        assertThat(drunk, is(ml));
    }

    @Test
    public void eat() throws Exception {
        final int kcal = 500;

        fitness.eat(kcal, dt);
        int eaten = fitness.eaten();

        assertThat(eaten, is(kcal));
    }
}