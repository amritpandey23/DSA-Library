package com.amritpandey23.dsalibrary.linkedlist;

import java.util.NoSuchElementException;

public interface List<T> {

	/**
	 * Retrieves the first node in the linked list.
	 *
	 * @return the first node in the linked list
	 * @throws NoSuchElementException if the list is empty
	 */
	Node<T> getFirst();

	/**
	 * Retrieves the last node in the linked list.
	 *
	 * @return the last node in the linked list
	 * @throws NoSuchElementException if the list is empty
	 */
	Node<T> getLast();

	/**
	 * Retrieves the node at a specified position in the linked list.
	 *
	 * @param position the position of the node to retrieve (0-based index)
	 * @return the node at the specified position
	 * @throws NoSuchElementException   if the list is empty
	 * @throws IllegalArgumentException if the position is out of bounds
	 */
	Node<T> getNodeAtPos(int position);

	/**
	 * Prints the linked list in a readable format.
	 */
	void print();

	/**
	 * Inserts a new node with the specified value at the beginning of the linked
	 * list.
	 *
	 * @param val the value to insert
	 */
	void insertFirst(T val);

	/**
	 * Inserts a new node with the specified value at the end of the linked list.
	 *
	 * @param val the value to insert
	 */
	void insertLast(T val);

	/**
	 * Inserts a new node with the specified value at a specific position in the
	 * linked list.
	 *
	 * @param val      the value to insert
	 * @param position the position at which to insert the new node (0-based index)
	 * @throws IllegalArgumentException if the position is out of bounds
	 */
	void insertAtPos(T val, int position) throws IllegalArgumentException;

	/**
	 * Deletes the first node in the linked list.
	 *
	 * @throws NoSuchElementException if the list is empty
	 */
	void deleteFirst();

	/**
	 * Deletes the last node in the linked list.
	 *
	 * @throws NoSuchElementException if the list is empty
	 */
	void deleteLast();

	/**
	 * Searches for a node with the specified value in the linked list.
	 *
	 * @param val the value to search for
	 * @return true if the value is found, false otherwise
	 */
	boolean search(T val);
	
	Node<T> reverse(Node<T> node);

}