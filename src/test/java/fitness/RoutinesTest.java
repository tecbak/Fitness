package fitness;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class RoutinesTest {
    private Fitness fitness;
    private LocalTime[] times;
    private String[] messages;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();
        times = new LocalTime[]{
                LocalTime.of(8, 0),
                LocalTime.of(8, 30),
                LocalTime.of(10, 0),
                LocalTime.of(11, 30)};
        messages = new String[]{
                "Glass of water",
                "Breakfast",
                "Glass of water",
                "Lunch"};
        for (int i = 0; i < 4; i++)
            fitness.addRoutine(times[i], messages[i]);
    }

    @Test
    public void testNextRoutine() throws Exception {
        String[] expected = new String[]{
                "Glass of water @ 08:00",
                "Breakfast @ 08:30",
                "Glass of water @ 10:00",
                "Lunch @ 11:30",
                "Nothing left to do today"};
        String[] actual = new String[]{
                fitness.nextRoutine(LocalTime.of(7, 0)),
                fitness.nextRoutine(LocalTime.of(8, 10)),
                fitness.nextRoutine(LocalTime.of(9, 0)),
                fitness.nextRoutine(LocalTime.of(10, 30)),
                fitness.nextRoutine(LocalTime.NOON)};
        Assert.assertArrayEquals(expected, actual);
    }
}