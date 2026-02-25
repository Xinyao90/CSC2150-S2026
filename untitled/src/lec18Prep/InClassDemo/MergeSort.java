package lec18Prep.InClassDemo;

import java.util.Arrays;
/**
 * MergeSort Demo
 *
 * Big Idea:
 * 1. Divide array into two halves
 * 2. Recursively sort each half
 * 3. Merge the two sorted halves
 *
 * Runtime: O(N log N)
 */
public class MergeSort {
    /**
     * Recursively sorts the array and returns a NEW sorted array.
     */
    public static int[] mergeSort(int[] arr) {
    /**
     * Merges two SORTED arrays into one sorted array.
     * This step runs in O(N).
     */
        if (arr.length <= 1) {
            return arr;
        }
        // Splitting array into two halves
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid); // [start, end)
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        // Recursive sort two halves
        left = mergeSort(left);
        right =mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] l, int[] r) {
        int[] result = new int[l.length + r.length];
        int i = 0; // index for left array
        int j = 0; // index for right array
        int k = 0; // index for result array

        //Compare elements in l and r, and copy into result
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                result[k++] = l[i++];
            } else {
                result[k++] = r[j++];
            }
        }
        // l still has leftover
        while(i < l.length) {
            result[k++] = l[i++];
        }
        // r still has leftover
        while(j < r.length) {
            result[k++] = r[j++];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, -1, 10, 4};
        int[] sorted = mergeSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
