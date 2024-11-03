package tree;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class LCAInBinaryTree {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        TreeNode root = TreeNode.generateSampleTree();
        int ans = LCA(root, -100, 78);
        TreeNode res = LCA2(root, -100, 78);
        System.out.println("LCA = " + ans);
        System.out.println("LCA2 = " + res.val);
	}

    public static TreeNode LCA2(TreeNode root, int n1, int n2) {
        /* Time complexity = O(n) : 1 traversal */
        if (root == null) {
            return null;
        }
        if (root.val == n1 || root.val == n2) {
            return root;
        }
        TreeNode lca1 = LCA2(root.left, n1, n2);
        TreeNode lca2 = LCA2(root.right, n1, n2);
        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        }
        return lca2;
    }

    public static int LCA(TreeNode root, int n1, int n2) {
        /* Time complexity = O(n) : 3 traversals */
        if (root == null) {
            return -1;
        }
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        findPath(root, n1, path1);
        findPath(root, n2, path2);
        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return -1;
    }

    public static boolean findPath(TreeNode root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.val == n) {
            path.add(root.val);
            return true;
        }
        path.add(root.val);
        if (findPath(root.left, n, path) || findPath(root.right, n, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
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
