package fitness;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DailyStatistics {
    private Fitness fitness;
    private LocalDate[] date;
    private LocalTime[] time;
    private LocalDateTime[] dateTime;
    private int[] volume;
    private int dailyNorm;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();
        date = new LocalDate[]{
                LocalDate.of(2016, 1, 1),
                LocalDate.of(2016, 1, 10),};
        time = new LocalTime[]{
                LocalTime.of(12, 30),
                LocalTime.of(15, 25),
                LocalTime.of(16, 30),
                LocalTime.of(17, 44)};
        dateTime = new LocalDateTime[]{
                LocalDateTime.of(date[0], time[0]),
                LocalDateTime.of(date[0], time[1]),
                LocalDateTime.of(date[1], time[2]),
                LocalDateTime.of(date[1], time[3])};
        volume = new int[]{500, 600, 1000, 1200};
        dailyNorm = 3000;
    }

    @Test
    public void leftToDrinkTest() throws Exception {
        fitness.setWaterDailyNorm(dailyNorm);

        fitness.drink(volume[0], dateTime[0]);
        fitness.drink(volume[1], dateTime[1]);
        fitness.drink(volume[2], dateTime[2]);
        fitness.drink(volume[3], dateTime[3]);

        int expected = dailyNorm - (volume[0] + volume[1]);
        int actual = fitness.leftToDrinkOnDate(date[0]);
        assertThat(actual, is(expected));

        expected = dailyNorm - (volume[2] + volume[3]);
        actual = fitness.leftToDrinkOnDate(date[1]);
        assertThat(actual, is(expected));
    }

    @Test
    public void leftToEatTest() throws Exception {
        fitness.setMealDailyNorm(dailyNorm);

        fitness.eat(volume[0], dateTime[0]);
        fitness.eat(volume[1], dateTime[1]);
        fitness.eat(volume[2], dateTime[2]);
        fitness.eat(volume[3], dateTime[3]);

        int expected = dailyNorm - (volume[0] + volume[1]);
        int actual = fitness.leftToEatOnDate(date[0]);
        assertThat(actual, is(expected));

        expected = dailyNorm - (volume[2] + volume[3]);
        actual = fitness.leftToEatOnDate(date[1]);
        assertThat(actual, is(expected));
    }

    @Test
    public void leftToWalkTest() throws Exception {
        fitness.setWalkDailyNorm(dailyNorm);

        fitness.walk(volume[0], dateTime[0]);
        fitness.walk(volume[1], dateTime[1]);
        fitness.walk(volume[2], dateTime[2]);
        fitness.walk(volume[3], dateTime[3]);

        int expected = dailyNorm - (volume[0] + volume[1]);
        int actual = fitness.leftToWalkOnDate(date[0]);
        assertThat(actual, is(expected));

        expected = dailyNorm - (volume[2] + volume[3]);
        actual = fitness.leftToWalkOnDate(date[1]);
        assertThat(actual, is(expected));
    }

    @Test
    public void drunkOnDateTest() throws Exception {
        fitness.drink(volume[0], dateTime[0]);
        fitness.drink(volume[1], dateTime[1]);
        fitness.drink(volume[2], dateTime[2]);
        fitness.drink(volume[3], dateTime[3]);

        int expected = volume[0] + volume[1] + volume[2] + volume[3];
        int actual = fitness.drunk();
        assertThat(actual, is(expected));
    }

    @Test
    public void eatenOnDateTest() throws Exception {
        fitness.eat(volume[0], dateTime[0]);
        fitness.eat(volume[1], dateTime[1]);
        fitness.eat(volume[2], dateTime[2]);
        fitness.eat(volume[3], dateTime[3]);

        int expected = volume[0] + volume[1] + volume[2] + volume[3];
        int actual = fitness.eaten();
        assertThat(actual, is(expected));
    }

    @Test
    public void walkedOnDateTest() throws Exception {
        fitness.walk(volume[0], dateTime[0]);
        fitness.walk(volume[1], dateTime[1]);
        fitness.walk(volume[2], dateTime[2]);
        fitness.walk(volume[3], dateTime[3]);

        int expected = volume[0] + volume[1] + volume[2] + volume[3];
        int actual = fitness.walked();
        assertThat(actual, is(expected));
    }
}
