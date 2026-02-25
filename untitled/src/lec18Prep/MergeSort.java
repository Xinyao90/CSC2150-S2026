package lec18Prep;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr, Counter c) {
        c.calls++;
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left, c);
        right = mergeSort(right, c);

        return merge(left, right, c);
    }

    private static int[] merge(int[] left, int[] right, Counter c) {
        int[] out = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            c.comparisons++;
            if (left[i] <= right[j]) {
                out[k++] = left[i++];
            } else {
                out[k++] = right[j++];
            }
            c.writes++;
        }

        while (i < left.length) {
            out[k++] = left[i++];
            c.writes++;
        }

        while (j < right.length) {
            out[k++] = right[j++];
            c.writes++;
        }

        return out;
    }

//    public static void main(String[] args) {
//        int[] data = {2, 3, 6, 10, 11, 4, 5, 7, 8};
//        Counter c = new Counter();
//
//        int[] sorted = mergeSort(data, c);
//        System.out.println(Arrays.toString(sorted));
//        System.out.println(c);
//    }
    public static void main(String[] args) {
        Counter c = new Counter();
        int[] arr1 = {2, 5, 1, 0, -1, 10, 4, 4};
        int[] sortedArray1 = mergeSort(arr1, c);
        System.out.println(Arrays.toString(sortedArray1));
        System.out.println(c);

        c.reset();
        int[] arr2 = {2, 5, 1, 0, -1, 10, 4};
        int[] sortedArray2 = mergeSort(arr2, c);
        System.out.println(Arrays.toString(sortedArray2));
        System.out.println(c);
    }

}

