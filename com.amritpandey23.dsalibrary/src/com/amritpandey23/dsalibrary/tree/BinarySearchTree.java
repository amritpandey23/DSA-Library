package com.amritpandey23.dsalibrary.tree;

/**
 * <b>Binary Search Tree Algorithms: Search, Insert, Delete, Validate.</b>
 * 
 * All the algorithms are implemented on <code>TreeNode<Integer></code> node.
 */
public class BinarySearchTree {

	/**
	 * Searches for a specified value in the binary search tree.
	 * 
	 * @param node the root of the binary search tree
	 * @param val  the value to search for
	 * @return {@code true} if the value is found in the tree, {@code false}
	 *         otherwise
	 */
	public static boolean search(TreeNode<Integer> node, Integer val) {
		if (node == null) {
			return false;
		}
		if (node.val.equals(val)) {
			return true;
		}
		if (node.val > val) {
			return search(node.left, val);
		}
		return search(node.right, val);
	}

	/**
	 * Inserts a specified value into the binary search tree. If the value already
	 * exists in the tree, it will not be duplicated.
	 * 
	 * @param node the root of the binary search tree
	 * @param val  the value to insert
	 * @return the root of the tree after insertion
	 */
	public static TreeNode<Integer> insert(TreeNode<Integer> node, Integer val) {
		if (node == null) {
			return new TreeNode<>(val);
		}
		if (val < node.val) {
			node.left = insert(node.left, val);
		} else if (val > node.val) {
			node.right = insert(node.right, val);
		}
		return node;
	}
}
