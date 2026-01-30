package lec8Prep;

public class Array1DTo2D {
    /**
     * Constructs an m x n 2D array from the 1D array original in row-major order.
     * If original.length != m * n, returns an empty 2D array: new int[0][0].
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original == null) {
            return new int[0][0];
        }
        if (m < 0 || n < 0) {
            return new int[0][0];
        }
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] out = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            int row = i / n; // row index
            int col = i % n; // col index
            out[row][col] = original[i];
        }
        return out;
    }
}
