package com.amritpandey23.dsalibrary.linkedlist;

public class DoublyListNode<T> implements Node {
	public T val;
	public DoublyListNode<T> next;
	public DoublyListNode<T> prev;

	public DoublyListNode(T val) {
		this(val, null, null);
	}

	public DoublyListNode(T val, DoublyListNode<T> next, DoublyListNode<T> prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}

	@Override
	public Object getValue() {
		return this.val;
	}

	@Override
	public Node getNext() {
		return this.next;
	}

	@Override
	public Node getPrevious() {
		return this.prev;
	}

	@Override
	public void setNext(Node next) {
		this.next = (DoublyListNode<T>) next;
	}

	@Override
	public void setPrevious(Node previous) {
		this.prev = (DoublyListNode<T>) previous;

	}
}
