package com.amritpandey23.dsalibrary.linkedlist;

public interface Node<T> {
	public T getValue();
	public Node<T> getNext();
	public Node<T> getPrevious();
	public void setNext(Node<T> next);
	public void setPrevious(Node<T> previous);
}
