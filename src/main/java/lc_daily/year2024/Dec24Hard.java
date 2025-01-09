package lc_daily.year2024;

import java.util.*;

public class Dec24Hard {
    public void solve() {
//        System.out.println(minimumDiameterAfterMerge(new int[][]{{0,1},{0,2},{0,3}}, new int[][]{{0,1}}));
        System.out.println(minimumDiameterAfterMerge(new int[][]{{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}}, new int[][]{{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}}));
//        System.out.println(minimumDiameterAfterMerge(new int[][]{{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}}, new int[][]{{0,1},{0,2},{0,3}, {3,4}}));
//        System.out.println(minimumDiameterAfterMerge(new int[][]{{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}}, new int[][]{{0,1},{0,2},{0,3}}));
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        createGraph(edges1, graph1);
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        createGraph(edges2, graph2);
        int a = getMaxDistance(graph1);
        int b = getMaxDistance(graph2);
        int c = (a+1)/2+(b+1)/2+1;

        return Math.max(Math.max(a,b), c);
    }

    private int getMaxDistance(Map<Integer, List<Integer>> graph) {
        int ans1[] = bfs(graph, 0);
        int ans2[] = bfs(graph, ans1[0]);
        System.out.println(ans2[0]+"->"+ans1[0]+":"+ans2[1]);
        return ans2[1];
    }

    private int[] bfs(Map<Integer, List<Integer>> graph, int startNode) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int farthestNode = startNode;
        int maxDistance = 0;

        q.add(new int[]{farthestNode, maxDistance});
        visited.add(farthestNode);

        while(!q.isEmpty()) {
            int[] pair = q.poll();
            int vertx = pair[0];
            int distance = pair[1];

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = vertx;
            }

            List<Integer> neighbors = graph.getOrDefault(vertx, new ArrayList<>());
            for(Integer neighbor: neighbors) {
                if(!visited.contains(neighbor)) {
//                    q.add(new int[]{neighbor, distance+1});
                    q.offer(new int[]{neighbor, distance + 1});
                    visited.add(neighbor);
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }

    /*
    private int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int vertx, int distance) {
        visited.add(vertx);
        if(distance>maxDistance) {
            farthestNode = vertx;
            maxDistance = distance;
        }
        List<Integer> neighbors = graph.getOrDefault(vertx, new ArrayList<>());
        for(Integer child: neighbors) {
            if(!visited.contains(child))
                maxDiameter(graph, visited, child, distance+1);
        }
        return maxDistance;
    }

     */

    private void createGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
        for(int ed[] : edges) {
            graph.computeIfAbsent(ed[0], k -> new ArrayList<>()).add(ed[1]);
            graph.computeIfAbsent(ed[1], k -> new ArrayList<>()).add(ed[0]);
        }
    }
}
