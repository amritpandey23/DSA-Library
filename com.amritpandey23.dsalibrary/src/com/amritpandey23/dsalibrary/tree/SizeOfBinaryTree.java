package com.amritpandey23.dsalibrary.tree;

import java.util.ArrayDeque;

/**
 * <b>Calculate total number of nodes i.e. size of a binary tree.</b>
 * 
 * 
 * The word "size" is quite ambiguous as it can be mean many things in context
 * of a tree. It can very well mean the height or depth of the tree to a non-native
 * english speaker. Here we mean total number of nodes in the tree by "size" which
 * is a common term also used in the Java collections library.
 */
public class SizeOfBinaryTree {

    /**
     * Calculates the size of a binary tree recursively.
     * This method traverses the tree in a depth-first manner, summing up nodes in each subtree.
     *
     * @param node the root of the binary tree
     * @param <T>  the type of the values stored in the tree nodes
     * @return the total number of nodes in the tree
     */
    public static <T> Integer getSizeRecursively(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeRecursively(node.left) + getSizeRecursively(node.right);
    }

    /**
     * Calculates the size of a binary tree iteratively.
     * This method uses a breadth-first traversal (level-order) to count the nodes in the tree.
     *
     * @param node the root of the binary tree
     * @param <T>  the type of the values stored in the tree nodes
     * @return the total number of nodes in the tree
     */
    public static <T> Integer getSizeIteratively(TreeNode<T> node) {
        Integer result = 0;
        if (node == null) {
            return result;
        }

        ArrayDeque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.poll();
            result++;
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }
}
