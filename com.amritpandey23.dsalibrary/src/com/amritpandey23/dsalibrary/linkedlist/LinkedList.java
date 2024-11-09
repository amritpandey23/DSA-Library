package com.amritpandey23.dsalibrary.linkedlist;

import java.util.NoSuchElementException;

/**
 * A generic singly linked list implementation with common list operations.
 *
 * @param <T> the type of elements stored in the linked list
 */
public class LinkedList<T> {
    private ListNode<T> head;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Constructs a linked list with an initial head node containing the specified value.
     *
     * @param headVal the value of the initial head node
     */
    public LinkedList(T headVal) {
        this.head = new ListNode<>(headVal);
    }

    /**
     * Retrieves the first node in the linked list.
     *
     * @return the first node in the linked list
     * @throws NoSuchElementException if the list is empty
     */
    public ListNode<T> getFirst() {
        if (this.head == null) {
            throw new NoSuchElementException("List is not initialized with head value yet.");
        }
        return this.head;
    }

    /**
     * Retrieves the last node in the linked list.
     *
     * @return the last node in the linked list
     * @throws NoSuchElementException if the list is empty
     */
    public ListNode<T> getLast() {
        if (this.head == null) {
            throw new NoSuchElementException("List is not initialized with head value yet.");
        }
        ListNode<T> Ans = this.head;
        while (Ans.next != null) {
            Ans = Ans.next;
        }
        return Ans;
    }

    /**
     * Retrieves the node at a specified position in the linked list.
     *
     * @param position the position of the node to retrieve (0-based index)
     * @return the node at the specified position
     * @throws NoSuchElementException if the list is empty
     * @throws IllegalArgumentException if the position is out of bounds
     */
    public ListNode<T> getNodeAtPos(int position) {
        if (this.head == null) {
            throw new NoSuchElementException("List is not initialized with head value yet.");
        }
        if (position == 0) {
            return this.head;
        }
        int pos = 1;
        ListNode<T> Ans = this.head;
        while (Ans != null && pos < position) {
            Ans = Ans.next;
            pos++;
        }
        if (Ans == null || pos != position) {
            throw new IllegalArgumentException("No element found at position " + position
                    + ". Did the position exceed the length of the list? Or you might have passed an invalid position value.");
        }
        return Ans;
    }

    /**
     * Prints the linked list in a readable format.
     */
    public void print() {
        if (this.head == null) {
            System.out.println("[]");
        }
        System.out.print("[");
        ListNode<T> itr = this.head;
        while (itr != null) {
            System.out.print(itr.val);
            if (itr.next != null) {
                System.out.print(", ");
            }
            itr = itr.next;
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Inserts a new node with the specified value at the beginning of the linked list.
     *
     * @param val the value to insert
     */
    public void insertFirst(T val) {
        ListNode<T> node = new ListNode<>(val);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = head;
            this.head = node;
        }
    }

    /**
     * Inserts a new node with the specified value at the end of the linked list.
     *
     * @param val the value to insert
     */
    public void insertLast(T val) {
        ListNode<T> node = new ListNode<>(val);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode<T> lastNode = getLast();
            lastNode.next = node;
        }
    }

    /**
     * Inserts a new node with the specified value at a specific position in the linked list.
     *
     * @param val      the value to insert
     * @param position the position at which to insert the new node (0-based index)
     * @throws IllegalArgumentException if the position is out of bounds
     */
    public void insertAtPos(T val, int position) throws IllegalArgumentException {
        ListNode<T> prevNode = null;
        try {
            prevNode = getNodeAtPos(position - 1);
        } catch (NoSuchElementException e) {
            this.head = new ListNode<>(val);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        ListNode<T> newNode = new ListNode<>(val);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    /**
     * Deletes the first node in the linked list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteFirst() {
        if (this.head == null) {
            throw new NoSuchElementException("List is not initialized with head value yet.");
        }
        this.head = head.next;
    }

    /**
     * Deletes the last node in the linked list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteLast() {
        if (this.head == null) {
            throw new NoSuchElementException("List is not initialized with head value yet.");
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        ListNode<T> deleteNodePrev = head;
        while (deleteNodePrev.next.next != null) {
            deleteNodePrev = deleteNodePrev.next;
        }
        deleteNodePrev.next = null;
    }
}
