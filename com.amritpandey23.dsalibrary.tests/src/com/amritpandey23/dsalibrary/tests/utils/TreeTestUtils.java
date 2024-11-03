package com.amritpandey23.dsalibrary.tests.utils;

import com.amritpandey23.dsalibrary.tree.TreeNode;

public class TreeTestUtils {
    public static TreeNode<Integer> generateTestTree() {
        TreeNode<Integer> node = new TreeNode<>(1);
        
        node.left = new TreeNode<>(2);
        node.left.left = new TreeNode<>(3);
        node.left.right = new TreeNode<>(4);
        node.left.right.left = new TreeNode<>(5);
        node.left.right.right = new TreeNode<>(6);
        
        node.right = new TreeNode<>(7);
        node.right.left = new TreeNode<>(8);
        node.right.right = new TreeNode<>(9);
        node.right.left.left = new TreeNode<>(10);
        node.right.left.right = new TreeNode<>(11);
        
        return node;
    }
}

