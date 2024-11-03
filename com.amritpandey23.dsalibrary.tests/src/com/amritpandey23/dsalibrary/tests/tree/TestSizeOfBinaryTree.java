package com.amritpandey23.dsalibrary.tests.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.tests.utils.TreeTestUtils;
import com.amritpandey23.dsalibrary.tree.SizeOfBinaryTree;
import com.amritpandey23.dsalibrary.tree.TreeNode;

public class TestSizeOfBinaryTree {
	@Test
	public void _whenTreeContainsNoNodes_ThenSizeOfTreeIsZero() {
		assertEquals(0, SizeOfBinaryTree.getSizeRecursively(null), "The size of null tree should be 0");
		assertEquals(0, SizeOfBinaryTree.getSizeIteratively(null), "The size of null tree should be 0");
	}

	@Test
	public void _whenTreeContainsOneNode_ThenSizeOfTreeIsOne() {
		assertEquals(1, SizeOfBinaryTree.getSizeRecursively(new TreeNode<Integer>(1)), "The size of tree should be 1");
		assertEquals(1, SizeOfBinaryTree.getSizeIteratively(new TreeNode<Integer>(1)), "The size of tree should be 1");
	}

	@Test
	public void _whenTreeContainsTwoNodes_ThenSizeOfTreeIsTwo() {
		assertEquals(2, SizeOfBinaryTree.getSizeRecursively(new TreeNode<Integer>(1, new TreeNode<Integer>(2), null)),
				"The size of tree should be 2");
		assertEquals(2, SizeOfBinaryTree.getSizeIteratively(new TreeNode<Integer>(1, new TreeNode<Integer>(2), null)),
				"The size of tree should be 2");
	}
	
	@Test
	public void _whenTreeContains11Nodes_ThenSizeOfTreeIs11() {
		assertEquals(11, SizeOfBinaryTree.getSizeRecursively(TreeTestUtils.generateTestTree()),
				"The size of tree should be 11");
		assertEquals(11, SizeOfBinaryTree.getSizeIteratively(TreeTestUtils.generateTestTree()),
				"The size of tree should be 11");
	}
}
