package tree;

import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class DiameterOfTree {
    private static Scanner sc = new Scanner(System.in);
    private static Map<TreeNode, Integer> HeightMap = new HashMap<>();
    private static int maxDia = 0;

    public static void main(String[] args) {
        // code here
        TreeNode root = TreeNode.generateSampleTree();

        calcMaxDia3(root);
        System.out.println(maxDia);

        processHeight(root);
        System.out.println(calcMaxDia2(root));

        System.out.println(calcMaxDia(root));
    }

    public static int calcMaxDia3(TreeNode root) {
        /* efficient solution, O(n) with no space
        complexity */
        if (root == null) {
            return 0;
        }
        int hl = calcMaxDia3(root.left);
        int hr = calcMaxDia3(root.right);
        maxDia = Math.max(maxDia, 1 + hl + hr);
        return 1 + Math.max(hl, hr);
    }

    public static int calcMaxDia2(TreeNode root) {
        /* better than calcMaxDia, the height are saved
        in hashmap, but space complexity is O(n) */
        if (root == null) {
            return 0;
        }

        int hl = HeightMap.getOrDefault(root.left, 0);
        int hr = HeightMap.getOrDefault(root.right, 0);
        int dia = hl + hr + 1;
        return Math.max(
                dia,
                Math.max(
                        calcMaxDia(root.left),
                        calcMaxDia(root.right)));
    }

    public static void processHeight(TreeNode root) {
        if (root != null) {
            HeightMap.put(root, height(root));
            processHeight(root.left);
            processHeight(root.right);
        }
    }

    public static int calcMaxDia(TreeNode root) {
        /* inefficient approach, height is calculated
        every time for each node */
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        int dia = hl + hr + 1;
        return Math.max(
                dia,
                Math.max(
                        calcMaxDia(root.left),
                        calcMaxDia(root.right)));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public static void print(int[] A) {
        for (int n : A) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode generateSampleTree() {
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(20);
            root.right = new TreeNode(30);
            root.left.right = new TreeNode(50);
            root.right.left = new TreeNode(40);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(78);
            root.right.left.right = new TreeNode(-100);
            return root;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> Q = new ArrayDeque<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int count = Q.size(); // important step
            // do not use Q.size() in loop termination
            // as Q.size() keep variying
            for (int i = 0; i < count; i++) {
                TreeNode current = Q.poll();
                System.out.print(current.val + " ");
                if (current.left != null) {
                    Q.offer(current.left);
                }
                if (current.right != null) {
                    Q.offer(current.right);
                }
            }
            System.out.println();
        }
    }
}
