package org.year2024;

import java.util.*;

public class Dec25Med {
    public void solve() {
        System.out.println(largestValues(createTree(new int[]{1,2,3,4,5,6,7,8,9,10}, 0)));
//        System.out.println(largestValues(createTree(new int[]{1,3,2,5,3,-1,9}, 0)));
    }

    private TreeNode3 createTree(int[] arr, int i) {
        if(i>=arr.length) return null;
        if(arr[i]==-1) return null;
        TreeNode3 node = new TreeNode3(arr[i]);
        node.left = createTree(arr, 2*i+1);
        node.right = createTree(arr, 2*i+2);
        return node;
    }

    private List<Integer> largestValues(TreeNode3 root) {
        /*
        Queue<Pair3> queue = new LinkedList<>();
        queue.add(new Pair3(0, root));
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()) {
            Pair3 pair = queue.poll();
            int level = pair.level;
            TreeNode3 node = pair.node;
            map.computeIfAbsent(level, k -> new PriorityQueue<>((x,y) -> Integer.compare(y, x))).add(node.val);
            if(node.left!=null) queue.offer(new Pair3(level+1, node.left));
            if(node.right!=null) queue.offer(new Pair3(level+1, node.right));
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            ans.add(entry.getValue().peek());
        }
        return ans;

         */

        Queue<TreeNode3> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            for(int i=0; i< queue.size(); i++) {
                TreeNode3 current = queue.poll();
                System.out.print(current.val+" ");
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
        }

        return null;
    }

    static class Pair3 {
        int level;
        TreeNode3 node;

        Pair3(int level, TreeNode3 node) {
            this.level = level;
            this.node = node;
        }
    }
}

class TreeNode3 {
    TreeNode3 left;
    int val;
    TreeNode3 right;

    TreeNode3(int val) {
        this.val = val;
    }
}

