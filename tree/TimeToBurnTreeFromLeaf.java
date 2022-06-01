package tree;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class TimeToBurnTreeFromLeaf {
	private static Scanner sc = new Scanner(System.in);
    private static int res = 0;
    public static class Distance {
        int val;
        Distance(int d) {
            val = d;
        }
    }

	public static void main(String[] args) {
		//code here
        TreeNode root = TreeNode.generateSampleTree();
        System.out.println(burnTime(root, -100, new Distance(-1)));
	}

    public static int burnTime(TreeNode root, int leaf, Distance d) {
        if (root == null) {
            return 0;
        }
        if (root.val == leaf) {
            d.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);
        if (lh != -1) {
            d.val = ldist.val + 1;
            res = Math.max(res, rh + d.val);
        } else if (rh == -1) {
            d.val = rdist.val + 1;
            res = Math.max(res, lh + d.val);
        }
        return 1 + Math.max(lh, rh);
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
