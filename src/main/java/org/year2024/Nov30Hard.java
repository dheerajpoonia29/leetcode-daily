package org.year2024;

import java.util.*;

public class Nov30Hard {
//    https://leetcode.com/problems/valid-arrangement-of-pairs/description/

    public void solve() {
//        int[][] grid = new int[][]{{5,1}, {4,5}, {11,9}, {9,4}};
//        int[][] grid = new int[][]{{1,3}, {3,2}, {2,1}};
//        int[][] grid = new int[][]{{1,2}, {1,3}, {2,1}};
        int[][] grid = new int[][]{{0, 1}, {2, 3}, {1, 4}, {1, 2}, {3, 1}, {5 ,1}, {4, 5}};
        int[][] ans= validArrangement(grid);
        for(int[] arr: ans) {
            System.out.println(arr[0]+" "+arr[1]);
        }
    }

    public int[][] validArrangement(int[][] grid) {
        Set<Integer> nodeList = new HashSet<>();
        Map<Integer, List<Integer>> adjList = initGraph(grid, grid.length, nodeList);
        int n = grid.length;

        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        nodeList.forEach(i -> {
            in.put(i, 0);
            out.put(i, 0);
        });

        calculateInOut(adjList, in, out);

        int start = calStart(in, out, nodeList), end = calEnd(in, out, nodeList);

        System.out.println(start+" "+end+"\n\n");

        return dfs(n, adjList, start, end, in, out);
    }

    private int[][] dfs(int n, Map<Integer, List<Integer>> adjList, int start, int end, Map<Integer, Integer> in, Map<Integer, Integer> out) {
        Stack<Integer> st = new Stack<>();

        if(start != -1) {
            st.push(start);
        }
        else {
            Map.Entry<Integer, List<Integer>> entry = adjList.entrySet().iterator().next();
            st.push(entry.getKey());
        }

        List<int[]> ans = new ArrayList<>();

        while(!st.empty()) {
            int node = st.peek();

            // find next edge
            if (out.get(node)!=0) {
                out.put(node, out.get(node)-1);

                List<Integer> neighbors = adjList.get(node);
                int nextNode = neighbors.remove(0);
                in.put(nextNode, in.get(nextNode)-1);

                st.push(nextNode);
            } else {
                // no more edge
                st.pop();
                if(!st.empty()) {
                    ans.add(new int[]{st.peek(), node});
                }
            }
        }

        Collections.reverse(ans);

        return ans.toArray(new int[n][2]);
    }

    private int calStart(Map<Integer, Integer> in, Map<Integer, Integer> out, Set<Integer> nodeList) {
        for (Integer node : nodeList) {
            if(out.get(node) - in.get(node) == 1) {
                return node;
            }
        }
        return -1;
    }

    private int calEnd(Map<Integer, Integer> in, Map<Integer, Integer> out, Set<Integer> nodeList) {
        for (Integer node : nodeList) {
            if(in.get(node) - out.get(node) == 1) {
                return node;
            }
        }
        return -1;
    }

    private void calculateInOut(Map<Integer, List<Integer>> adjList, Map<Integer, Integer> in, Map<Integer, Integer> out) {
        adjList.forEach((k, valueList) -> {
            for(Integer v: valueList) {
                out.put(k, out.getOrDefault(k, 0)+1);
                in.put(v, in.getOrDefault(v, 0)+1);
            }
        });
    }

    private Map<Integer, List<Integer>> initGraph(int[][] ans, int length, Set<Integer> nodeList) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<length; i++) {
            addEdge(map, ans[i][0], ans[i][1]);
            nodeList.add(ans[i][0]);
            nodeList.add(ans[i][1]);
        }
        return map;
    }

    public void addEdge(Map<Integer, List<Integer>> adjList, int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }
}
