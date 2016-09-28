import org.junit.Before;
import org.junit.Test;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
    public void drinkWater() throws Exception {
        final int waterVolume = 200;

        fitness.drinkWater(waterVolume, dt);
        assertThat(fitness.drunkWater(), is(waterVolume));

    }
}