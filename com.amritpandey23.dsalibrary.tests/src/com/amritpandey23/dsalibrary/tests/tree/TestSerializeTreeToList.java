package com.amritpandey23.dsalibrary.tests.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.tree.SerializeTreeToList;
import com.amritpandey23.dsalibrary.tree.TreeNode;

public class TestSerializeTreeToList {
	@Test
	public void _whenTreeNodeIsNull_ThenReturnEmptyList() {
		List<Integer> serializedTree = SerializeTreeToList.serializeTree(null);

		assertEquals(0, serializedTree.size(), "Null tree node should result in empty list");
	}

	@Test
	public void _whenTreeWithOneNode_ThenReturnList() {
		TreeNode<Integer> node = new TreeNode<>(1);
		List<Integer> serializedTree = SerializeTreeToList.serializeTree(node);

		assertNotNull(serializedTree, "Null tree node should result in non-null list");
		List<Integer> verificationList = Arrays.asList(new Integer[] { 1, null, null });
		assertEquals(verificationList, serializedTree, "Wrong serialized tree list found.");
	}

	@Test
	public void _whenTreeWithTwoNodes_ThenReturnList() {
		TreeNode<Integer> node = new TreeNode<>(2);
		node.left = new TreeNode<Integer>(3);
		List<Integer> serializedTree = SerializeTreeToList.serializeTree(node);

		assertEquals(5, serializedTree.size(), "Size of the tree must be 5");
		List<Integer> verificationList = Arrays.asList(new Integer[] { 2, 3, null, null, null });
		assertEquals(verificationList, serializedTree, "Wrong serialized tree list found.");
	}

	@Test
	public void _whenTreeWithTreeNodes_ThenReturnList() {
		TreeNode<Integer> node = new TreeNode<>(2, new TreeNode<Integer>(3), new TreeNode<Integer>(4));

		List<Integer> serializedTree = SerializeTreeToList.serializeTree(node);

		assertEquals(7, serializedTree.size(), "Size of the tree must be 7");
		List<Integer> verificationList = Arrays.asList(new Integer[] { 2, 3, 4, null, null, null, null });
		assertEquals(verificationList, serializedTree, "Wrong serialized tree list found.");
	}
}
