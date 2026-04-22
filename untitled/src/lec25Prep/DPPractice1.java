package lec25Prep;

public class DPPractice1 {

    /**
     * Returns the length of the longest ascending contiguous subarray.
     */
    public static int longestAscendingSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        // TODO 1: base case
        // dp[0] should be ?

        int globalMax = dp[0];

        for (int i = 1; i < nums.length; i++) {
            // TODO 2:
            // If nums[i] > nums[i - 1], extend previous ascending subarray
            // Otherwise, start over from length 1

            // TODO 3:
            // update globalMax
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(longestAscendingSubarray(nums)); // expected: 4
    }
}
