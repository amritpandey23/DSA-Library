package com.amritpandey23.dsalibrary.tests.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.tests.utils.TreeTestUtils;
import com.amritpandey23.dsalibrary.tree.BinarySearchTree;
import com.amritpandey23.dsalibrary.tree.SerializeTreeToList;
import com.amritpandey23.dsalibrary.tree.TreeNode;

public class TestBinarySearchTree {
	@Test
	public void testSearchInBST() {
		TreeNode<Integer> bst = TreeTestUtils.generateBST();
		
		assertTrue(BinarySearchTree.search(bst, 4));
		assertFalse(BinarySearchTree.search(bst, 11));
	}
	
	@Test
	public void testInsertInBST() {
		TreeNode<Integer> bst = TreeTestUtils.generateBST();
		
		BinarySearchTree.insert(bst, 8);
		assertTrue(BinarySearchTree.search(bst, 8));
		
		BinarySearchTree.insert(bst, 0);
		assertTrue(BinarySearchTree.search(bst, 0));
	}
	
	@Test
	public void testDeleteInBST() {
		TreeNode<Integer> bst = TreeTestUtils.generateBST();
		
		BinarySearchTree.delete(bst, 7);
		assertFalse(BinarySearchTree.search(bst, 7));
		assertTrue(BinarySearchTree.search(bst, 1));
	}
}
