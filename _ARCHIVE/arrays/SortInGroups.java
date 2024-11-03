package arrays;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:



*/

public class SortInGroups {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        int k = 3;
        sortInGroups(arr, n, k);
        for (int t : arr) {
            System.out.print(t + " ");
        }
	}

    public static void sortInGroups(int[] arr, int n, int k) {
        for (int i = 0; i < n; i+=k) {
            int low, high;
            low = i;
            high = (i + k - 1);
            if (high >= n) {
                high = n -1;
            }
            while (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] =temp;
                low++;
                high--;
            }
        }
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
