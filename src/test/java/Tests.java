import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Tests {
    @Test
    public void myTest() throws Exception {
        List mockedList = mock(ArrayList.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void nextTest() throws Exception {
        List mockedList = spy(LinkedList.class);

        when(mockedList.size()).thenReturn(1);
        assertThat(mockedList.size(), is(1));
    }
}
