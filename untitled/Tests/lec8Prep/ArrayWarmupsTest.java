package lec8Prep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayWarmupsTest {

    // ===== sumPositives tests =====
    @Test
    public void testSumPositives_basic() {
        assertEquals(4, SumOfPositives.sumPositives(new int[]{1, -2, 3, 0}));
    }

    @Test
    public void testSumPositives_allNegativeOrZero() {
        assertEquals(0, SumOfPositives.sumPositives(new int[]{-1, -2, 0, -10}));
    }

    @Test
    public void testSumPositives_allPositive() {
        assertEquals(15, SumOfPositives.sumPositives(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testSumPositives_empty() {
        assertEquals(0, SumOfPositives.sumPositives(new int[]{}));
    }

    @Test
    public void testSumPositives_null() {
        assertEquals(0, SumOfPositives.sumPositives(null));
    }

    // ===== lastIndexOf tests =====
    @Test
    public void testLastIndexOf_foundMultiple() {
        assertEquals(3, LastIndexOf.lastIndexOf(new int[]{2, 7, 2, 2}, 2));
    }

    @Test
    public void testLastIndexOf_foundOnce() {
        assertEquals(1, LastIndexOf.lastIndexOf(new int[]{5, 9, 8}, 9));
    }

    @Test
    public void testLastIndexOf_notFound() {
        assertEquals(-1, LastIndexOf.lastIndexOf(new int[]{5, 9, 8}, 7));
    }

    @Test
    public void testLastIndexOf_empty() {
        assertEquals(-1, LastIndexOf.lastIndexOf(new int[]{}, 1));
    }

    @Test
    public void testLastIndexOf_null() {
        assertEquals(-1, LastIndexOf.lastIndexOf(null, 1));
    }

    // ===== insertTwoAt3 tests =====
    @Test
    public void testInsertTwoAt3_example() {
        int[] a = {1, 2, 3, 4, 5};
        int[] out = InsertTwoValues.insertTwoAt3(a, 9, 10);
        assertArrayEquals(new int[]{1, 2, 3, 9, 10, 4, 5}, out);
    }

    @Test
    public void testInsertTwoAt3_negativeValues() {
        int[] a = {0, 0, 0, 0, 0};
        int[] out = InsertTwoValues.insertTwoAt3(a, -7, -8);
        assertArrayEquals(new int[]{0, 0, 0, -7, -8, 0, 0}, out);
    }

    @Test
    public void testInsertTwoAt3_doesNotMutateInput() {
        int[] a = {1, 2, 3, 4, 5};
        int[] copy = {1, 2, 3, 4, 5};
        InsertTwoValues.insertTwoAt3(a, 9, 10);
        assertArrayEquals(copy, a); // original should remain unchanged
    }

    @Test
    public void testInsertTwoAt3_wrongLengthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> InsertTwoValues.insertTwoAt3(new int[]{1, 2, 3}, 9, 10));
    }

    @Test
    public void testInsertTwoAt3_nullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> InsertTwoValues.insertTwoAt3(null, 9, 10));
    }

    @Test
    public void example1() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{1,2,3,4}, 2, 2);
        assertArrayEquals(new int[][]{{1,2},{3,4}}, ans);
    }

    @Test
    public void example2() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{1,2,3}, 1, 3);
        assertArrayEquals(new int[][]{{1,2,3}}, ans);
    }

    @Test
    public void example3_impossible() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{1,2}, 1, 1);
        assertEquals(0, ans.length); // empty 2D array: 0 rows
    }

    @Test
    public void preservesOrder_rowMajor() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{5,6,7,8,9,10}, 2, 3);
        assertArrayEquals(new int[][]{{5,6,7},{8,9,10}}, ans);
    }

    @Test
    public void singleCell() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{42}, 1, 1);
        assertArrayEquals(new int[][]{{42}}, ans);
    }

    @Test
    public void emptyOriginal_m0n0() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(new int[]{}, 0, 0);
        assertEquals(0, ans.length);
    }

    @Test
    public void nullOriginal_returnsEmpty() {
        Array1DTo2D s = new Array1DTo2D();
        int[][] ans = s.construct2DArray(null, 2, 2);
        assertEquals(0, ans.length);
    }

    @Test
    public void invalidDimensions_returnsEmpty() {
        Array1DTo2D s = new Array1DTo2D();
        assertEquals(0, s.construct2DArray(new int[]{1,2}, -1, 2).length);
        assertEquals(0, s.construct2DArray(new int[]{1,2}, 1, -2).length);
    }
}
