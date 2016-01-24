package net.kodfodrasz.matrixspiral.test;

import java.util.Arrays;
import java.util.List;
import net.kodfodrasz.matrixspiral.MatrixSpiral;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class SpiralTest {

    @Test
    public void spiralOf_emptyMatrixTest() {
        List<List<Integer>> matrix = Arrays.asList();

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void spiralOf_emptyRowTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList()
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void spiralOf_SingleElementRowTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1);
    }

    @Test
    public void spiralOf_SingleRow2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void spiralOf_SingleRowMultipleElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    public void spiralOf_SingleRowMultipleElementsTest2() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void spiralOf_SingleColumn2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void spiralOf_SingleColumnMultipleElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    public void spiralOf_SingleColumnMultipleElementsTest2() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void spiralOf_2by3ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3, 6, 5, 4);
    }

    @Test
    public void spiralOf_3by2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 4, 6, 5, 3);
    }

    @Test
    public void spiralOf_3by3ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
    }

    @Test
    public void spiralOf_4by5ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20)
        );

        List<Integer> result = MatrixSpiral.spiral(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12);
    }
}
