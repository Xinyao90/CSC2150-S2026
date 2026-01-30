package lec8Prep;

public class LastIndexOf {
    /**
     * Returns the last index where target appears in a, or -1 if not found.
     * If a is null, returns -1.
     */
    public static int lastIndexOf(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static void main(String[] args) {
        int[] a = {2, 7, 2, 2};
        System.out.println(lastIndexOf(a, 2));
        int[] b = new int[0];
        System.out.println(lastIndexOf(b, 1));
        int[] c = null;
        System.out.println(lastIndexOf(c, 3));
    }
}

