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
        Integer[][] matrix = new Integer[][]{};

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_emptyRowTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleElementRowTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRow2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleRowMultipleElementsTest2() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3, 4}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumn2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2},
            new Integer[]{3}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_SingleColumnMultipleElementsTest2() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2},
            new Integer[]{3},
            new Integer[]{4}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_2by3ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3},
            new Integer[]{4, 5, 6},};

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_3by2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2},
            new Integer[]{3, 4},
            new Integer[]{5, 6}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).isNull();
    }

    @Test
    public void submatrixOf_3by3ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3},
            new Integer[]{4, 5, 6},
            new Integer[]{7, 8, 9}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result[0]).containsExactly(5);
    }

    @Test
    public void submatrixOf_4by5ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3, 4, 5},
            new Integer[]{6, 7, 8, 9, 10},
            new Integer[]{11, 12, 13, 14, 15},
            new Integer[]{16, 17, 18, 19, 20}
        };

        Integer[][] result = MatrixSpiral.submatrix(matrix);        

        assertThat(result).hasSize(2);
        assertThat(result[0]).containsExactly(7, 8, 9);
        assertThat(result[1]).containsExactly(12, 13, 14);
    }
}
