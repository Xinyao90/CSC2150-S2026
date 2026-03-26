package lec21Prep;

import java.util.PriorityQueue;

public class findKthLargestSolution {
    public static int findKthLargest(int[] nums, int k) {
        //TODO
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            if (minheap.size() < k){
                minheap.offer(num);
            } else {
                if(minheap.peek() < num) {
                    minheap.offer(num);
                    minheap.poll();
                }
            }
//            if (minheap.size() > k) {
//                minheap.poll();
//            }
        }
        return minheap.peek();
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
