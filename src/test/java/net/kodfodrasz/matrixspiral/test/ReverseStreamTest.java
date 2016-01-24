package net.kodfodrasz.matrixspiral.test;

import java.util.stream.Stream;
import net.kodfodrasz.matrixspiral.MatrixSpiral;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class ReverseStreamTest {

    @Test
    public void emptyArrayTest() {
        Integer[] arr = new Integer[0];

        Integer[] reversed = MatrixSpiral.reverseStream(Stream.of(arr)).toArray(Integer[]::new);

        assertThat(reversed).isNotNull().isEmpty();
    }

    @Test
    public void singleElementArrayTest() {
        Integer[] arr = new Integer[]{1};

        Integer[] reversed = MatrixSpiral.reverseStream(Stream.of(arr)).toArray(Integer[]::new);

        assertThat(reversed).isNotNull().containsExactly(1);
    }

    @Test
    public void twoElementArrayTest() {
        Integer[] arr = new Integer[]{1, 2};

        Integer[] reversed = MatrixSpiral.reverseStream(Stream.of(arr)).toArray(Integer[]::new);

        assertThat(reversed).isNotNull().containsExactly(2, 1);
    }

    @Test
    public void manyElementArrayTest() {
        Integer[] arr = new Integer[]{1, 2, 5, 7, 12, 5};

        Integer[] reversed = MatrixSpiral.reverseStream(Stream.of(arr)).toArray(Integer[]::new);

        assertThat(reversed).isNotNull().containsExactly(5, 12, 7, 5, 2, 1);
    }

}
