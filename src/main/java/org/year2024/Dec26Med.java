package org.year2024;

public class Dec26Med {
    public void solve() {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0, 0);
    }

    private int find(int[] nums, int target, int i, int sum) {
        if(i == nums.length && sum == target) {
            return 1;
        } else if(i >= nums.length) {
            return 0;
        }
        return find(nums, target, i+1, sum+nums[i]) + find(nums, target, i+1, sum-nums[i]);
    };
}
