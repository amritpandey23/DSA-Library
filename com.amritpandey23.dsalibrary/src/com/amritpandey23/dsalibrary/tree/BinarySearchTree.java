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

	/**
	 * Deletes a specified value from the binary search tree.
	 * 
	 * @param node the root of the binary search tree
	 * @param val  the value to delete
	 * @return the root of the tree after deletion
	 */
	public static TreeNode<Integer> delete(TreeNode<Integer> node, Integer val) {
		if (node == null) {
			return null;
		}

		if (node.val > val) {
			// if value is smaller, move to left sub tree
			node.left = delete(node.left, val);
		} else if (node.val < val) {
			// if value is larger, move to right sub tree
			node.right = delete(node.right, val);
		} else {
			// Node to be deleted found
			if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			}

			// If the node already has two children then we need to get the
			// a node which is just bigger than current node but smaller then
			// other nodes in the right side of the tree.

			// Node with two children: get the inorder successor (smallest in the right
			// subtree)
			TreeNode<Integer> successorNode = getSuccessor(node);
			node.val = successorNode.val;

			// Delete the successor
			node.right = delete(node.right, successorNode.val);
		}

		return node;
	}

	/**
	 * Finds the inorder successor of a given node in the binary search tree. The
	 * inorder successor is the smallest node in the right subtree.
	 *
	 * @param node the node for which the successor is to be found
	 * @return the inorder successor node
	 */
	private static TreeNode<Integer> getSuccessor(TreeNode<Integer> node) {
		if (node == null) {
			return null;
		}

		TreeNode<Integer> currentNode = node.right;
		while (currentNode != null && currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;
	}

	/**
	 * Validates if the given binary tree is a binary search tree (BST).
	 *
	 * @param node the root of the binary tree to validate
	 * @return {@code true} if the tree is a valid binary search tree, {@code false}
	 *         otherwise
	 */
	public static boolean validate(TreeNode<Integer> node) {
		return validate(node, null, null);
	}

	/**
	 * Helper method to validate the binary search tree by maintaining a range for
	 * each node.
	 *
	 * @param node the current node to validate
	 * @param min  the minimum allowable value for the current node (null if no
	 *             minimum)
	 * @param max  the maximum allowable value for the current node (null if no
	 *             maximum)
	 * @return {@code true} if the subtree rooted at the current node is a valid
	 *         BST, {@code false} otherwise
	 */
	private static boolean validate(TreeNode<Integer> node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
			return false;
		}

		return validate(node.left, min, node.val) && validate(node.right, node.val, max);
	}

}
