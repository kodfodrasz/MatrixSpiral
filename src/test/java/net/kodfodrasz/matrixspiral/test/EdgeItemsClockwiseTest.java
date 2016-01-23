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
        Integer[][] matrix = new Integer[][]{};

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void edgeitemsOf_emptyRowTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).hasSize(0);
    }

    @Test
    public void edgeitemsOf_SingleElementRowTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1);
    }

    @Test
    public void edgeitemsOf_SingleRow2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void edgeitemsOf_SingleRowMultipleElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    public void edgeitemsOf_SingleRowMultipleElementsTest2() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3, 4}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void edgeitemsOf_SingleColumn2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void edgeitemsOf_SingleColumnMultipleElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2},
            new Integer[]{3}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    public void edgeitemsOf_SingleColumnMultipleElementsTest2() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1},
            new Integer[]{2},
            new Integer[]{3},
            new Integer[]{4}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void edgeitemsOf_2by3ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3},
            new Integer[]{4, 5, 6}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3, 6, 5, 4);
    }

    @Test
    public void edgeitemsOf_3by2ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2},
            new Integer[]{3, 4},
            new Integer[]{5, 6}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 4, 6, 5, 3);
    }

    @Test
    public void edgeitemsOf_3by3ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3},
            new Integer[]{4, 5, 6},
            new Integer[]{7, 8, 9}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3, 6, 9, 8, 7, 4);
    }

    @Test
    public void edgeitemsOf_4by5ElementsTest() {
        Integer[][] matrix = new Integer[][]{
            new Integer[]{1, 2, 3, 4, 5},
            new Integer[]{6, 7, 8, 9, 10},
            new Integer[]{11, 12, 13, 14, 15},
            new Integer[]{16, 17, 18, 19, 20}
        };

        Integer[] result = MatrixSpiral.edgeItemsClockwise(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6);
    }
}
