package com.amritpandey23.dsalibrary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Serialization of binary tree to array/list.
 * 
 * This algorithm is useful in comparing contents of two binary trees.
 */
public class SerializeTreeToList {

	/**
	 * Serializes the binary tree rooted at the specified node into a list using
	 * level-order traversal. Each level of the tree is represented in order, with
	 * `null` values for missing nodes.
	 *
	 * @param node the root of the binary tree to be serialized
	 * @param <T>  the type of the values stored in the tree nodes
	 * @return a list containing the values of the tree nodes in level-order, with
	 *         `null` for absent children
	 */
	public static <T> List<T> serializeTree(TreeNode<T> node) {
		List<T> result = new ArrayList<>();

		if (node == null) {
			return result; // Return an empty list if the root is null
		}

		ArrayDeque<TreeNode<T>> queue = new ArrayDeque<>();
		queue.add(node);
		result.add(node.val);

		while (!queue.isEmpty()) {
			TreeNode<T> currentNode = queue.poll();

			// Process the left child
			if (currentNode.left != null) {
				queue.add(currentNode.left);
				result.add(currentNode.left.val);
			} else {
				result.add(null); // Use null to represent missing left child
			}

			// Process the right child
			if (currentNode.right != null) {
				queue.add(currentNode.right);
				result.add(currentNode.right.val);
			} else {
				result.add(null); // Use null to represent missing right child
			}
		}

		return result;
	}
}
