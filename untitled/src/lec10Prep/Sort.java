package lec10Prep;

public class Sort {
    /** Sort the strings in alphabetical order. */
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sort the strings in alphabetical order, staring from index k */
    public static void sort(String[] x, int k) {
        if (k == x.length) {
            return;
        }
        int smallest = findSmallest(x, k);
        swap(x, k, smallest);
        sort(x, k + 1);
    }

    /** Returns index of smallest string. */
    public static int findSmallest(String[] x, int k) {
        int curSmallest = k;
        for (int i = k; i < x.length; i++) {
            if (x[i].compareTo(x[curSmallest]) < 0) {
                curSmallest = i;
            }
        }
        return curSmallest;
    }

    public static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

}
