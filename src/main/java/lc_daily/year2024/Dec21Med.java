package lc_daily.year2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dec21Med {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();

//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        int[] arr = new int[]{2,3,5,8,13,21,34};
        int[] arr = new int[]{1,2,3,4,5,6,7};

//        tree = tree.balanceBstNodeInsertion(arr, 0, arr.length-1);
        tree = tree.levelOrderNodeInsertion(arr, 0);

        tree.bfsTraversal(tree);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode balanceBstNodeInsertion(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = balanceBstNodeInsertion(arr, start, mid - 1);
        node.right = balanceBstNodeInsertion(arr, mid + 1, end);
        return node;
    }

    public TreeNode levelOrderNodeInsertion(int[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        TreeNode node = new TreeNode(arr[i]);
        node.right = levelOrderNodeInsertion(arr, 2 * i + 1);   // Left child at index 2*i + 1
        node.left = levelOrderNodeInsertion(arr, 2 * i + 2);  // Right child at index 2*i + 2
        return node;
    }

    public void bfsTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        List<List<TreeNode>> lst = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll(); // Remove the front node from the queue
            TreeNode currentNode = pair.node;
            System.out.println("Node: " + currentNode.val + ", Level: " + pair.level);
            if(lst.size()<pair.level+1) {
                lst.add(new ArrayList<>());
            }
            lst.get(pair.level).add(currentNode);

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, pair.level+1));
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, pair.level+1));
            }
        }

        System.out.println(lst);

        for(int i=0; i<lst.size(); i++) {
            if(i%2!=0) {
                List<TreeNode> ls = lst.get(i);
                int p = 0, q = ls.size()-1;
                while(p<q) {
                    int tmp = ls.get(p).val;
                    ls.get(p).val = ls.get(q).val;
                    ls.get(q).val = tmp;
                    p++; q--;
                }
            }
        }

        System.out.println(lst);
    }

    static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
