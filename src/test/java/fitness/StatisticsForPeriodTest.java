package fitness;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class StatisticsForPeriodTest {
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
                LocalDate.of(2016, 1, 4),};
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



    @Ignore
    @Test
    public void drunkRateForPeriodTest() throws Exception {
        fitness.getWaterDailyNorm();
        fitness.drink(volume[0], dateTime[0]);
        fitness.drink(volume[1], dateTime[1]);
        fitness.drink(volume[2], dateTime[2]);
        fitness.drink(volume[3], dateTime[3]);

//        int expected =
//        int actual = fitness.drunkRateForPeriod(LocalDate start, LocalDate end);

    }
}
