package org.year2024;

public class Dec20Med {
    public void solve() {
//        maxChunksToSorted(new int[]{1,2,4,3,0}); //1
//        maxChunksToSorted(new int[]{4,1,2,0,3}); //1
//        maxChunksToSorted(new int[]{1,0,2,4,3}); //3
        maxChunksToSorted(new int[]{6,5,4,0,1,2,3}); //3
    }

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunk=0;

        int i = 0;

        while(i<n) {
            if(i==arr[i]) {
                chunk++;
                i++;
            } else if(i!=arr[i]) {
                int mx = arr[i];
                int j = i+1;
                while(j<n && j<=mx) {
                    mx = Math.max(mx, arr[j]);
                    j++;
                }
                i = mx+1;
                chunk++;
            }
        }

        return chunk;
    }
}
