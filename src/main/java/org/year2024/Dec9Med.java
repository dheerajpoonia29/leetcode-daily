package org.year2024;

//https://leetcode.com/problems/special-array-ii/submissions/1474292524/

public class Dec9Med {
//
    public void solve() {
//        boolean[] ans = isArraySpecial(new int[]{3,4,1,2,6}, new int[][]{{0,4}});
//        boolean[] ans = isArraySpecial(new int[]{4,3,1,6}, new int[][]{{0,2}, {2,3}});
//        boolean[] ans = isArraySpecial(new int[]{1,1}, new int[][]{{0,1}});
//        boolean[] ans = isArraySpecial(new int[]{4,5,2,7}, new int[][]{{1,3}});
        boolean[] ans = isArraySpecial(new int[]{3,7,8}, new int[][]{{0,3}});
        System.out.println(ans);
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = 0;
        for(int i=1; i<n; i++){
            if(nums[i-1]%2!=nums[i]%2) {
                prefixSum[i] = prefixSum[i-1]+1;
            } else {
                prefixSum[i] = prefixSum[i-1];
            }
        }

        boolean[] ans = new boolean[queries.length];
        int i = 0;

        for(int[] query: queries) {
            int start = query[0];
            int end = query[1];

            ans[i++] = (prefixSum[end]-prefixSum[start])==(end-start) ? true : false;
        }

        return ans;
    }
}
