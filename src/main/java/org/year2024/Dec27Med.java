package org.year2024;

public class Dec27Med {
    public void solve() {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair2(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair2(new int[]{1,2}));
        System.out.println(maxScoreSightseeingPair2(new int[]{5, 5, 5, 5, 5}));
        System.out.println(maxScoreSightseeingPair2(new int[]{1, 2, 3, 4, 1000}));
    }


    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        for(int i=0; i<values.length-1; i++) {
            for(int j = i+1; j<values.length; j++) {
                ans = Math.max(ans, values[i]+values[j]+(i-j));
            }
        }
        return ans;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int iMax = values[0];
        int ans = 0;
        for(int j=1; j< values.length; j++) {
            ans = Math.max(ans, iMax+values[j]-j);
            iMax = Math.max(iMax, values[j]+j);
        }
        return ans;
    }

}
