package net.kodfodrasz.matrixspiral.test;

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
        int[][] matrix = new int[][]{};

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void submatrixOf_emptyRowTest() {
        int[][] matrix = new int[][]{
            new int[]{}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleElementRowTest() {
        int[][] matrix = new int[][]{
            new int[]{1}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRow2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest2() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3, 4}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumn2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2},
            new int[]{3}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result[0]).containsExactly(2);
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest2() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2},
            new int[]{3},
            new int[]{4}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(2);
        assertThat(result[0]).containsExactly(2);
        assertThat(result[1]).containsExactly(3);

    }

    @Test
    public void submatrixOf_3by3ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result[0]).containsExactly(5);
    }

    @Test
    public void submatrixOf_2by3ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},};

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_3by2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2},
            new int[]{3, 4},
            new int[]{5, 6}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result[0]).containsExactly(3, 4);
    }
}
