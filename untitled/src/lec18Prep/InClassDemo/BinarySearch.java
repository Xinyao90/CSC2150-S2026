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
     */
    public static int binarySearchRec(int[] arr, int target, int lo, int hi) {
        return -1;
    }
    /**
     * Iterative Binary Search
     */
    public static int binarySearchIter(int[] arr, int target) {
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArr = {6, 13, 14, 25, 33, 43, 51, 53};
        System.out.println(binarySearchRec(sortedArr, 33, 0, sortedArr.length - 1));
        System.out.println(binarySearchIter(sortedArr, 25));
        System.out.println(binarySearchIter(sortedArr, 100));  // not found
    }
}
