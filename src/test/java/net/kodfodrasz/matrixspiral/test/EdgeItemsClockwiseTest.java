package net.kodfodrasz.matrixspiral.test;

import net.kodfodrasz.matrixspiral.MatrixSpiral;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author egabger
 */
public class EdgeItemsClockwiseTest {

    @Test
    public void edgeitemsOf_emptyMatrixTest() {
        int[][] matrix = new int[][]{};

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void edgeitemsOf_emptyRowTest() {
        int[][] matrix = new int[][]{
            new int[]{}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void edgeitemsOf_SingleElementRowTest() {
        int[][] matrix = new int[][]{
            new int[]{1}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(1).containsExactly(1);
    }

    @Test
    public void edgeitemsOf_SingleRow2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2);
    }

    @Test
    public void edgeitemsOf_SingleRowMultipleElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2, 3);
    }

    @Test
    public void edgeitemsOf_SingleRowMultipleElementsTest2() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3, 4}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void edgeitemsOf_SingleColumn2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2);
    }

    @Test
    public void edgeitemsOf_SingleColumnMultipleElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2},
            new int[]{3}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2, 3);
    }

    @Test
    public void edgeitemsOf_SingleColumnMultipleElementsTest2() {
        int[][] matrix = new int[][]{
            new int[]{1},
            new int[]{2},
            new int[]{3},
            new int[]{4}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(2).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void edgeitemsOf_3by3ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(8).containsExactly(1, 2, 3, 6, 9, 8, 7, 4);
    }

    @Test
    public void edgeitemsOf_2by3ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6}
        };

        int[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(6).containsExactly(1, 2, 3, 6, 5, 4);
    }

    @Test
    public void edgeitemsOf_3by2ElementsTest() {
        int[][] matrix = new int[][]{
            new int[]{1, 2},
            new int[]{3, 4},
            new int[]{5, 6}
        };

        int[][] result = MatrixSpiral.submatrix(matrix);

        assertThat(result).hasSize(1);
        assertThat(result[0]).hasSize(6).containsExactly(1, 2, 4, 6, 5, 3);
    }
}
