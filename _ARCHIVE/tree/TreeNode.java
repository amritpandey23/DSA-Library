package tree;

public class TreeNode {
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
        return root;
    }
}
