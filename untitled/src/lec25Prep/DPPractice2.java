package lec25Prep;

public class DPPractice2 {

    /**
     * Returns true if we can reach the last index.
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];

        // TODO 1: base case
        // The last index can always reach itself

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = false;

            // TODO 2:
            // Try every reachable next position j from i
            // If any such j has dp[j] == true, then dp[i] = true
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};

        System.out.println(canJump(a)); // expected: true
        System.out.println(canJump(b)); // expected: false
    }
}
