package org.year2024;

import java.util.Arrays;

public class Dec22Hard {
    public void solve() {
//        leftmostBuildingQueries(new int[]{6,4,8,5,2,7}, new int[][]{{0,1},{0,3},{2,4},{3,4},{2,2}});
        leftmostBuildingQueries(new int[]{5,3,8,2,6,1,4,6}, new int[][]{{1,3}});
//        leftmostBuildingQueries(new int[]{1}, new int[][]{{0,0}});
//        leftmostBuildingQueries(new int[]{1,2,1,2,1,2}, new int[][]{{1,0}, {0,1}, {0,2}, {0,4}});
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int ans[] = new int[queries.length];
        Arrays.fill(ans, -1);
        int j = 0;

        for(int[] q: queries) {
            int x = Math.min(q[0], q[1]);
            int y = Math.max(q[0], q[1]);

            if(x==y || heights[x]<heights[y]) {
                ans[j] = y;
            } else {
                for(int t=y+1; t<heights.length; t++) {
                    if(heights[x]<heights[t]) {
                        ans[j] = t;
                        break;
                    }
                }
            }

            j++;
        }

        return ans;
    }
}
