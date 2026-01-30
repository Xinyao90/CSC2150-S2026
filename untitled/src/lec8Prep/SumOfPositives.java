package lec8Prep;

public class SumOfPositives {
    /**
     * Returns the sum of all positive numbers in the array.
     * Positive means > 0 (zero does not count).
     * If a is null, returns 0 (you can change to throw if you prefer).
     */
    public static int sumPositives(int[] a) {
        if (a == null) {
            return 0;
        }
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int current = a[i];
            if (current > 0) {
                sum += current;
            }
        }
        return sum;
    }

    static void main(String[] args) {
        int[] a = {1, -2, 3, 0};
        System.out.println(sumPositives(a));
        int[] b = new int[0];
        System.out.println(sumPositives(b));
        int[] c = null;
        System.out.println(sumPositives(c));
    }
}
