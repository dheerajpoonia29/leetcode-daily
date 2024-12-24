package org.year2024;

import java.util.*;

public class Dec23Med {
    public void solve() {
//        TreeNode2 root = TreeNode2.levelOrderNodeInsertion(new int[]{1,2,3,4,5,6,7,8,9,10}, 0);
//        TreeNode2 root = TreeNode2.levelOrderNodeInsertion(new int[]{1,4,3,7,6,8,5,-1,-1,-1,-1,9,-1,10}, 0);
        TreeNode2 root = TreeNode2.levelOrderNodeInsertion(new int[]{1,2,3,4,5,6}, 0);
        System.out.println(minimumOperations(root));
//        System.out.println("dfs");
//        root.dfsTraversal(root, 0);
//        System.out.println("bfs");
//        root.bfsTraversal(root);
    }

    public int minimumOperations(TreeNode2 root) {
        return root.bfsTraversal2(root);
    }
}

class TreeNode2 {
    TreeNode2 left;
    int val;
    TreeNode2 right;

    TreeNode2(int val) {
        this.val = val;
    }

    public static TreeNode2 levelOrderNodeInsertion(int[] arr, int i) {
        if(i>=arr.length) return null;
        if(arr[i]==-1) return null;
        TreeNode2 node = new TreeNode2(arr[i]);
        node.left = levelOrderNodeInsertion(arr, 2*i+1);
        node.right = levelOrderNodeInsertion(arr, 2*i+2);
        return node;
    }

    public void dfsTraversal(TreeNode2 root, int level) {
        System.out.println(level+" "+root.val);
        if(root.left!=null)
            dfsTraversal(root.left, level+1);
        if(root.right!=null)
            dfsTraversal(root.right, level+1);
    }

    public void bfsTraversal(TreeNode2 root) {
        if (root == null) return;

        Queue<TreeNode2> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();  // Queue to track levels
        q.add(root);
        levels.add(0);  // Root is at level 0

        while (!q.isEmpty()) {
            TreeNode2 currNode = q.poll();
            int level = levels.poll();
            System.out.println(level + " " + currNode.val);

            if (currNode.left != null) {
                q.add(currNode.left);
                levels.add(level + 1);  // Left child is at the next level
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                levels.add(level + 1);  // Right child is at the next level
            }
        }

        System.out.println();
    }

    public int bfsTraversal2(TreeNode2 root) {
        if (root == null) return 0;

        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode2> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();  // Queue to track levels
        q.add(root);
        levels.add(0);  // Root is at level 0

        while (!q.isEmpty()) {
            TreeNode2 currNode = q.poll();
            int level = levels.poll();
            if(list.size()<level+1) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(currNode.val);

            if (currNode.left != null) {
                q.add(currNode.left);
                levels.add(level + 1);  // Left child is at the next level
            }
            if (currNode.right != null) {
                q.add(currNode.right);
                levels.add(level + 1);  // Right child is at the next level
            }
        }

        int ans = 0;
        for(List<Integer> ls : list) {
            ans += minSwapsToSort(ls.stream().mapToInt(Integer::intValue).toArray());
        }

        System.out.println();
        return ans;
    }

    public static int minSwapsToSort(int[] arr) {
        int n = arr.length;

        // Step 1: Create pairs of (element, index)
        List<int[]> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new int[] { arr[i], i });
        }

        // Step 2: Sort the array based on element values
        arrPos.sort(Comparator.comparingInt(o -> o[0]));

        // Step 3: Track visited elements
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // Step 4: Traverse and count cycles
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // If element is already in the correct position or visited, skip it
            if (visited[i] || arrPos.get(i)[1] == i) {
                continue;
            }

            // Find the cycle of this element
            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrPos.get(j)[1]; // Move to the next index in the cycle
                cycleLength++;
            }

            // If cycle length is greater than 1, add the required swaps
            if (cycleLength > 1) {
                swaps += (cycleLength - 1);
            }
        }

        return swaps;
    }
}