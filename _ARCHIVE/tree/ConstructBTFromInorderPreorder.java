package tree;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class ConstructBTFromInorderPreorder {
	private static Scanner sc = new Scanner(System.in);
    private static int preIndex = 0;

    public static void main(String[] args) {
        int[] in = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] pre = {10, 20, 40, 50, 30, 70, 80, 90};
        TreeNode root = construct(in, pre, 0, in.length - 1);
        printTree(root);
	}

    public static TreeNode construct(int[] in, int[] pre, int is, int ie) {
        if (is > ie) {
            return null;
        }
        int val = pre[preIndex++];
        TreeNode root = new TreeNode(val);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == val) {
                inIndex = i;
                break;
            }
        }
        root.left = construct(in, pre, is, inIndex - 1);
        root.right = construct(in, pre, inIndex + 1, ie);
        return root;
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
