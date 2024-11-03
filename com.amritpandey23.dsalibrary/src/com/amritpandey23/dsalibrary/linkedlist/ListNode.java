package com.amritpandey23.dsalibrary.linkedlist;

/**
 * Represents a node in a singly linked list, containing a generic value and a
 * reference to the next node.
 *
 * @param <T> the type of the value stored in the list node
 */
public class ListNode<T> {

	/**
	 * The value stored in this list node.
	 */
	public T val;

	/**
	 * Pointer to the next node in the list.
	 */
	public ListNode<T> next;

	/**
	 * Constructs a list node with a specified value and no reference to the next
	 * node.
	 *
	 * @param val the value to be stored in this list node
	 */
	public ListNode(T val) {
		this.val = val;
	}

	/**
	 * Constructs a list node with a specified value and a reference to the next
	 * node.
	 *
	 * @param val  the value to be stored in this list node
	 * @param next the next node in the list
	 */
	public ListNode(T val, ListNode<T> next) {
		this.val = val;
		this.next = next;
	}
}
