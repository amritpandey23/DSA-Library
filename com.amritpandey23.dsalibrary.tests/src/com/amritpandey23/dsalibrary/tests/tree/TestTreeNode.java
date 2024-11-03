package com.amritpandey23.dsalibrary.tests.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.tree.TreeNode;

public class TestTreeNode {
	@Test
	public void testTreeNodeCreation() {
		TreeNode<Integer> node = new TreeNode<>(2);
		assertNotNull(node, "Node should be created");
		assertEquals(2, node.val, "Value of the node should be correctly set");
		assertNull(node.right, "Node right child should be null");
		assertNull(node.left, "Node left child should be null");
	}
}
