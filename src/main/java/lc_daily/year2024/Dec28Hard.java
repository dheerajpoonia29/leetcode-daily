package lc_daily.year2024;

import java.util.*;

public class Dec28Hard {
    public void solve() {
        int[] ans = maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);
//        int[] ans = maxSumOfThreeSubarrays(new int[]{1,2,3,4,5}, 2);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            pSum[i] = pSum[i-1]+nums[i];
        }

        List<List<Integer>> result = getCombinations(nums, k);

        // Print the result
        int idx = 1;
        for (List<Integer> combination : result) {
            System.out.print(idx++ + ". ");
            System.out.println(combination);
        }


        int ans = Integer.MAX_VALUE;
        for (List<Integer> list: result) {
            int sum = 0;
            for (Integer no: list) {
                if(no-k-1>=0) {
                    sum += pSum[no-1] - pSum[no-k-1];
                } else {
                    sum += pSum[no-1];
                }
            }
            ans = Math.min(ans, sum);
        }

        return new int[]{};
    }

    public static List<List<Integer>> getCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursion from index 0
        generateCombinations(arr, k, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper method to recursively generate combinations
    // Store only the second element of each subarray
    private static void generateCombinations(int[] arr, int k, int startIndex,
                                             List<Integer> currentCombination,
                                             List<List<Integer>> result) {
        int n = arr.length;

        // If the current combination covers the entire array
        if (startIndex >= n) {
            if (currentCombination.size() > 0) {
                result.add(new ArrayList<>(currentCombination)); // Add copy to result
            }
            return;
        }

        // Try every possible starting point for the next subarray
        for (int i = startIndex; i <= n - k; i++) {
            // Add the second element of the subarray to the current combination
            currentCombination.add(arr[i + k - 1]);

            // Recur to find the next subarray, skipping exactly `k` elements
            generateCombinations(arr, k, i + k, currentCombination, result);

            // Backtrack by removing the last added second element
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
