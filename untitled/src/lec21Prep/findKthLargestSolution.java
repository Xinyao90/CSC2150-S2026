package lec21Prep;

import java.util.PriorityQueue;

public class findKthLargestSolution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if(minHeap.peek() < num) {
                    minHeap.offer(num);
                    minHeap.poll();// remove smallest
                }
            }
//            if (minHeap.size() > k) {
//                minHeap.poll(); // remove smallest
//            }
        }
        return minHeap.peek(); // kth largest
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2)); // Expected: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4)); // Expected: 4

        int[] nums3 = {1};
        System.out.println(findKthLargest(nums3, 1)); // Expected: 1

        int[] nums4 = {5, 5, 5, 5};
        System.out.println(findKthLargest(nums4, 2)); // Expected: 5

        int[] nums5 = {-1, -2, -3, -4};
        System.out.println(findKthLargest(nums5, 2)); // Expected: -2
    }
}
