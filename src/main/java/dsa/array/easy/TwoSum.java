package dsa.array.easy;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2,7,11,15}, 22);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(hp.containsKey(nums[i])) {
                return new int[]{hp.get(nums[i]), i};
            } else {
                hp.put(diff, i);
            }
        }

        return new int[2];
    }
}
