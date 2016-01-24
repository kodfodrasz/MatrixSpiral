package net.kodfodrasz.matrixspiral.test;

import java.util.Arrays;
import java.util.List;
import net.kodfodrasz.matrixspiral.MatrixSpiral;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author egabger
 */
public class SubMatrixTest {

    @Test
    public void submatrixOf_emptyMatrixTest() {
        List<List<Integer>> matrix = Arrays.asList();

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_emptyRowTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList()
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleElementRowTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRow2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest2() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumn2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest2() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_2by3ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_3by2ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_3by3ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsExactly(5);
    }

    @Test
    public void submatrixOf_4by5ElementsTest() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20)
        );

        List<List<Integer>> result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).containsExactly(7, 8, 9);
        assertThat(result.get(1)).containsExactly(12, 13, 14);
    }
}
