package fitness;

import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

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

    @Test
    public void walk() throws Exception {
        final int steps = 1000;

        fitness.walk(steps, dt);
        int walked = fitness.walked();

        assertThat(walked, is(steps));
    }

    @Test
    public void setAndGetWaterDailyNorm() throws Exception {
        final int ml = 2000;

        fitness.setWaterDailyNorm(ml);
        int waterDailyNorm = fitness.getWaterDailyNorm();

        assertThat(ml, is(waterDailyNorm));
    }

    @Test
    public void setAndGetMealDailyNorm() throws Exception {
        final int kcal = 2500;

        fitness.setMealDailyNorm(kcal);
        int mealDailyNorm = fitness.getMealDailyNorm();

        assertThat(kcal, is(mealDailyNorm));
    }

    @Test
    public void setAndGetWalkDailyNorm() throws Exception {
        final int steps = 2000;

        fitness.setWalkDailyNorm(steps);
        int walkDailyNorm = fitness.getWalkDailyNorm();

        assertThat(steps, is(walkDailyNorm));
    }
}