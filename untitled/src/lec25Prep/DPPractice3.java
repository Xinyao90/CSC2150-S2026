package lec25Prep;

public class DPPractice3 {

    /**
     * Returns the side length of the largest square of 1's.
     */
    public static int largestSquareOfOnes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // TODO 1:
                // If matrix[i][j] == 0, then dp[i][j] = 0

                // TODO 2:
                // If we're on first row or first column and matrix[i][j] == 1,
                // then dp[i][j] = 1

                // TODO 3:
                // Otherwise, if matrix[i][j] == 1:
                // dp[i][j] = 1 + min(top, left, topLeft)

                // TODO 4:
                // update maxSide
            }
        }

        return maxSide;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println(largestSquareOfOnes(matrix)); // expected: 2
    }
}
