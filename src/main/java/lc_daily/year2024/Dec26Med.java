package lc_daily.year2024;

import java.util.Arrays;
import java.util.Map;

public class Dec26Med {
    public void solve() {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            totalSum += num;
        }
//        return find(nums, target, 0, 0);
//        HashMap<String, Integer> c = new HashMap<>();
//        return find1(nums, target, 0, 0, new HashMap<>());
        int[][] memo = new int[nums.length][2*totalSum+1];
        for(int[] row: memo) Arrays.fill(row, Integer.MIN_VALUE);
        return find2(nums, target, 0, 0, memo);
    }

    int totalSum = 0;

    private int find2(int[] nums, int target, int i, int sum, int[][] memo) {
        if(i == nums.length) {
            if(sum == target) return 1;
            else return 0;
        } else {
            if(memo[i][sum+totalSum]!=Integer.MIN_VALUE) {
                return memo[i][sum+totalSum];
            }
            int add = find2(nums, target, i+1, sum+nums[i], memo);
            int sub = find2(nums, target, i+1, sum-nums[i], memo);
            memo[i][sum+totalSum] = add+sub;
            return add + sub;
        }
    }

    private int find1(int[] nums, int target, int i, int sum, Map<String, Integer> memo) {
        if(i == nums.length) {
            if(sum == target) return 1;
            else return 0;
        } else {
            String key = i + "," + (sum + totalSum);
            if(memo.containsKey(key)) {
                return memo.get(key);
            }
            int add = find1(nums, target, i+1, sum+nums[i], memo);
            int sub = find1(nums, target, i+1, sum-nums[i], memo);
            memo.put(key, add+sub);
            return add + sub;
        }
    }

    private int find(int[] nums, int target, int i, int sum) {
        if(i == nums.length) {
            if(sum == target) return 1;
            else return 0;
        } else {
            int add = find(nums, target, i+1, sum+nums[i]);
            int sub = find(nums, target, i+1, sum-nums[i]);
            return add + sub;
        }
    }
}
