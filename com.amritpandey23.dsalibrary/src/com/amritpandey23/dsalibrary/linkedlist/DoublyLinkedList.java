package com.amritpandey23.dsalibrary.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements List<T> {
	DoublyListNode<T> head;

	@Override
	public DoublyListNode<T> getFirst() {
		if (this.head == null) {
			throw new NoSuchElementException("List has not yet be initialized.");
		}
		return this.head;
	}

	@Override
	public DoublyListNode<T> getLast() {
		if (this.head == null) {
			throw new NoSuchElementException("List has not yet be initialized.");
		}
		DoublyListNode<T> Ans = head;
		while (Ans.next != null) {
			Ans = Ans.next;
		}
		return Ans;
	}

	@Override
	public DoublyListNode<T> getNodeAtPos(int position) {
		return null;
	}

	@Override
	public void print() {

	}

	@Override
	public void insertFirst(Object val) {

	}

	@Override
	public void insertLast(Object val) {

	}

	@Override
	public void insertAtPos(T val, int position) throws IllegalArgumentException {
		if (this.head == null) {
			throw new NoSuchElementException("List has not been initialized yet.");
		}
		int i = 0;
		DoublyListNode<T> ptr = head;
		while (ptr != null && i < position) {
			ptr = ptr.next;
			i++;
		}
		if (ptr == null || position < 0) {
			throw new IllegalArgumentException("Cannot insert node at given position. Did position exceeded the size of the list? Or did you specified a negative position value?");
		}
		DoublyListNode<T> newNode = new DoublyListNode<>(val);

		DoublyListNode<T> store = ptr.next;

		ptr.next = newNode;
		newNode.prev = ptr;

		newNode.next = store;
		if (store != null) {
			store.prev = newNode;
		}
	}

	@Override
	public void deleteFirst() {

	}

	@Override
	public void deleteLast() {

	}

	@Override
	public boolean search(Object val) {
		return false;
	}

	@Override
	public Node<T> reverse(Node<T> node) {
		return null;
	}

}
