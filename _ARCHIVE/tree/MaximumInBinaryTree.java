package tree;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class MaximumInBinaryTree {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        TreeNode root = TreeNode.generateSampleTree();
        System.out.println(getMax(root));
	}

    public static int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));
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
}
