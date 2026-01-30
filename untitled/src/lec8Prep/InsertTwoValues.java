package lec8Prep;

import java.util.Arrays;

public class InsertTwoValues {
    /**
     * Given an array a of length 5, returns a new array of length 7
     * where p and q are inserted starting at index 3.
     *
     * Example:
     * a = [1,2,3,4,5], p=9, q=10 -> [1,2,3,9,10,4,5]
     *
     * Uses System.arraycopy.
     */
    public static int[] insertTwoAt3(int[] a, int p, int q) {
        if (a == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (a.length != 5) {
            throw new IllegalArgumentException("Expected array of length 5.");
        }
        int[] out = new int[7];

        // Copy first part: a[0..2] -> out[0..2]
        System.arraycopy(a, 0, out, 0, 3);

        // Insert p, q at indices 3 and 4
        out[3] = p;
        out[4] = q;

        // Copy remaining part: a[3..4] -> out[5..6]
        System.arraycopy(a, 3, out, 5, 2);

        return out;
    }

    static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(insertTwoAt3(a, 9, 10)));
        int[] b = new int[0];
        System.out.println(insertTwoAt3(b, 9, 10));
        int[] c = null;
        System.out.println(insertTwoAt3(c, 9, 10));
    }
}
