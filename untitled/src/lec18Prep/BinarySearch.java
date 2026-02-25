package lec18Prep;

public class BinarySearch {
    public static int binarySearchRec(int[] arr, int target, int lo, int hi, Counter c) {
        c.calls++;
        if (hi < lo) return -1;
        int mid = lo + (hi - lo) / 2;
        c.comparisons++;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) { // target on the right
            return binarySearchRec(arr, target, mid + 1, hi, c);
        } else { // target on the left
            return binarySearchRec(arr, target, lo, mid - 1, c);
        }
    }

    public static int binarySearchIter(int[] arr, int target, Counter c) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (hi >= lo) {
            c.calls++;
            mid = lo + (hi - lo) / 2;
            c.comparisons++;
            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    static void main(String[] args) {
        Counter c = new Counter();
        int[] arr1 = {6, 13, 14, 25, 33, 43, 51, 53, 64};
        System.out.println(binarySearchRec(arr1, 33, 0, arr1.length - 1, c));
        System.out.println(c);

        c.reset();
        int[] arr2 = {6, 13, 14, 25, 33, 43, 51, 53};
        System.out.println(binarySearchRec(arr2, 33, 0, arr2.length - 1, c));
        System.out.println(c);

        c.reset();
        int[] arr3 = {6, 13};
        System.out.println(binarySearchRec(arr3, 33, 0, arr3.length - 1, c));
        System.out.println(c);

        c.reset();
        System.out.println(binarySearchIter(arr1, 33,  c));
        System.out.println(c);

        c.reset();
        System.out.println(binarySearchIter(arr2, 33,  c));
        System.out.println(c);

        c.reset();
        System.out.println(binarySearchIter(arr3, 33, c));
        System.out.println(c);

    }
}
