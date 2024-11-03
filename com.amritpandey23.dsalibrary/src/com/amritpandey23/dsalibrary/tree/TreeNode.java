package com.amritpandey23.dsalibrary.tree;

/**
 * Represents a node in a binary tree structure with a generic value and pointers to the left and right child nodes.
 *
 * @param <T> the type of the value stored in the tree node
 */
public class TreeNode<T> {
    
    /**
     * The value stored in this tree node.
     */
    public T val;

    /**
     * Pointer to the right child node.
     */
    public TreeNode<T> right;

    /**
     * Pointer to the left child node.
     */
    public TreeNode<T> left;

    /**
     * Constructs a tree node with a specified value and no children.
     *
     * @param val the value to be stored in this tree node
     */
    public TreeNode(T val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }

    /**
     * Constructs a tree node with a specified value, left child, and right child.
     *
     * @param val  the value to be stored in this tree node
     * @param left the left child node
     * @param right the right child node
     */
    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

