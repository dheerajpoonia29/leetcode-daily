package lc_daily.year2024;

import java.util.*;

// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/?envType=daily-question&envId=2024-11-28
public class Nov28Hard {
    public static int[] rowDir = {-1, 1, 0, 0};
    public static int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        // Example grid
//        int[][] grid = {
//                {1, 1, 0, 1},
//                {0, 1, 1, 0},
//                {1, 0, 1, 1},
//                {1, 1, 1, 0}
//        };

//        int[][] grid = {
//                {0, 1, 1, 1, 0},
//                {0, 0, 0, 1, 0},
//                {0, 1, 0, 1, 0}
//        };


        int[][] grid = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 1, 0}
        };


        bfsTraversal(grid);
    }

    private static int bfsTraversal(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

//        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

//        boolean[][][] visited = new boolean[rows][cols][rows*cols];
        int[][] minObstacles = new int[rows][cols];
        for (int[] row : minObstacles) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize to a large value (infinity)
        }

        queue.add(new int[]{0, 0, 0, 0});
//        visited[0][0][0] = true;
        minObstacles[0][0] = 0;

        int ans = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            int obstaclesRemoved = current[2];

//            System.out.println(currRow+","+currCol);

            if(currRow == rows-1 && currCol == cols-1) {
                ans = Math.min(ans, obstaclesRemoved);
//                System.out.println("path found, step: "+step+", obsRemoved: "+ans);
                return ans;
            }

            for(int i=0; i<4; i++) {
                int nextRow = currRow + rowDir[i];
                int nextCol = currCol + colDir[i];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    int newObstaclesRemoved = obstaclesRemoved + (grid[nextRow][nextCol] == 1 ? 1 : 0);

//                    if (newObstaclesRemoved<rows*cols && !visited[nextRow][nextCol][newObstaclesRemoved]) {
//                        visited[nextRow][nextCol][newObstaclesRemoved] = true;
//                        queue.add(new int[]{nextRow, nextCol, step + 1, newObstaclesRemoved});
//                    }
                    if (newObstaclesRemoved < minObstacles[nextRow][nextCol]) {
                        minObstacles[nextRow][nextCol] = newObstaclesRemoved;
                        queue.add(new int[]{nextRow, nextCol, newObstaclesRemoved});
                    }
                }
            }
        }

//        System.out.println("path not found");
        return ans;
    }
}