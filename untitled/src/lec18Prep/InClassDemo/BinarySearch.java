package lec18Prep.InClassDemo;
/**
 * Binary Search Demo
 *
 * Important:
 * - Array MUST be sorted.
 * - Each step cuts search space in half.
 *
 * Runtime: O(log N)
 */
public class BinarySearch {
    /**
     * Recursive Binary Search
     * Space complexity: O(log N)
     */
    public static int binarySearchRec(int[] arr, int target, int lo, int hi) {
        if (hi < lo) { //base
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) { //look at right side from mid to hi
            return binarySearchRec(arr, target, mid + 1, hi);
        } else {
            return binarySearchRec(arr, target, lo, mid - 1); // look at left side from lo to mid
        }
    }
    /**
     * Iterative Binary Search
     * Space Complexity: O(1)
     */
    public static int binarySearchIter(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (hi >= lo) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) { // look at right half
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArr1 = {6, 13, 14, 25, 33, 43, 51, 53};
//        System.out.println(binarySearchRec(sortedArr1, 33, 0, sortedArr1.length - 1));
//        System.out.println(binarySearchRec(sortedArr1, 100, 0, sortedArr1.length - 1));
        System.out.println(binarySearchIter(sortedArr1, 25));
        System.out.println(binarySearchIter(sortedArr1, 100));  // not found
    }
}
