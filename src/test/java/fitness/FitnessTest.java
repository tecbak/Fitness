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

    @Test
    public void waterLeft() throws Exception {
        int waterDailyNorm = 3000;
        fitness.setWaterDailyNorm(waterDailyNorm);

        //Drink twice at one day
        LocalDate date0 = LocalDate.of(2016, 1, 1);
        LocalTime time00 = LocalTime.of(12, 30);
        LocalTime time01 = LocalTime.of(15, 25);
        LocalDateTime dateTime00 = LocalDateTime.of(date0, time00);
        LocalDateTime dateTime01 = LocalDateTime.of(date0, time01);
        int ml00 = 100;
        int ml01 = 200;
        fitness.drink(ml00, dateTime00);
        fitness.drink(ml01, dateTime01);

        //Drink once at another day
        LocalDate date1 = LocalDate.of(2016, 1, 10);
        LocalTime time10 = LocalTime.of(10, 10);
        LocalDateTime dateTime10 = LocalDateTime.of(date1, time10);
        int ml10 = 300;
        fitness.drink(ml10, dateTime10);

        int expected = waterDailyNorm - (ml00 + ml01);
        int left = fitness.waterLeft(date0);

        assertThat(left, is(expected));
    }
}