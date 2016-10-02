package fitness;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;

public class StatisticsForPeriodTest {
    private Fitness fitness;
    private LocalDate[] date;
    private LocalTime time;
    private LocalDateTime[] dateTime;
    private int[] volume;
    private int dailyNorm;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();
        date = new LocalDate[]{
                LocalDate.of(2016, 1, 1),
                LocalDate.of(2016, 1, 2),
                LocalDate.of(2016, 1, 3),
                LocalDate.of(2016, 1, 4)};
        time = LocalTime.NOON;
        dateTime = new LocalDateTime[]{
                LocalDateTime.of(date[0], time),
                LocalDateTime.of(date[1], time),
                LocalDateTime.of(date[2], time),
                LocalDateTime.of(date[3], time)};
        volume = new int[]{500, 600, 1000, 1200};
        dailyNorm = 3000;
    }


    @Ignore
    @Test
    public void drunkRateForPeriodTest() throws Exception {
        fitness.getWaterDailyNorm();
        fitness.drink(volume[0], dateTime[0]);
        fitness.drink(volume[1], dateTime[1]);
        fitness.drink(volume[2], dateTime[2]);
        fitness.drink(volume[3], dateTime[3]);

        int expected = 800;
        int actual = fitness.drunkRateForPeriod(date[0], date[3]);

        Assert.assertThat(actual, is(expected));
    }
}
