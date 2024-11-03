package tree;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class PrintLeftView {
	private static Scanner sc = new Scanner(System.in);

    public static int levelsCovered = 0;

	public static void main(String[] args) {
		//code here
        TreeNode root = TreeNode.generateSampleTree();
        leftView(root, 1);
        System.out.println();
        leftViewIterative(root);
	}

    public static void leftViewIterative(TreeNode root) {
        // idea: use level order to print
        // first node at each level
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> Q = new ArrayDeque<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int count = Q.size();
            for (int i = 0; i < count; i++) {
                TreeNode current = Q.poll();
                if (i == 0) {
                    System.out.print(current.val + " ");
                }
                if (current.left != null) {
                    Q.offer(current.left);
                }
                if (current.right != null) {
                    Q.offer(current.right);
                }
            }
        }
    }

    public static void leftView(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        /*
        at each level we are first printing the left
        node, if that particular level is already 
        covered then no need to print other left nodes
        at the same level. To know which left nodes
        has to be printed we maintain the levelCovered
        variable that tells if the particular level is
        printed or not by comparing the next level that
        we want.
        */
        if (levelsCovered < level) {
            System.out.print(root.val + " ");
            levelsCovered = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
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
