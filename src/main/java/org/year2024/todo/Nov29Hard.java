package org.year2024.todo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nov29Hard {
//    https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid
    public void solve() {
        int[][] grid = new int[][]{
                {0, 1, 3, 2},
                {5, 1, 2, 5},
                {4, 3, 8, 6}
        };
//        int[][] grid = new int[][]{
//                {0, 2, 4},
//                {3, 2, 1},
//                {1, 0, 4}
//        };
        System.out.println(bfsTraversal(grid));
    }

    public int[] moveRow = new int[]{-1, 1, 0, 0};
    public int[] moveCol = new int[]{0, 0, -1, 1};

    public int bfsTraversal(int[][] grid) {
        if(grid[0][0]!=0) {
            return -1;
        }

        if(grid[0][0]+1<grid[0][1] && grid[0][0]+1<grid[1][0]) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];


            if(currRow==rows-1 && currCol==cols-1) {
                return currTime;
            }

            for(int i=0; i<4; i++) {
                int newRow = currRow + moveRow[i];
                int newCol = currCol + moveCol[i];

                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;

                    int newTime = currTime + 1;
                    int waitTime = grid[newRow][newCol];

                    if(waitTime > newTime) {
                        if((waitTime - currTime)%2!=0) {
                            newTime = waitTime;
                        } else {
                            newTime = waitTime + 1;
                        }
                    }

                    queue.add(new int[]{newTime, newRow, newCol});

                }
            }
        }

        return -1;
    }
}
