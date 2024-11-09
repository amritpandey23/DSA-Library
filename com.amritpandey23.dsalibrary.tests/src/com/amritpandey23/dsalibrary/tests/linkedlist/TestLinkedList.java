package com.amritpandey23.dsalibrary.tests.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.linkedlist.LinkedList;

public class TestLinkedList {
	@Test
	public void testLinkedListCreation() {
		LinkedList<Integer> list = new LinkedList<>();
		assertNotNull(list);

		list = new LinkedList<Integer>(1);
		assertNotNull(list);
		assertNotNull(list.getFirst());
		assertEquals(1, list.getFirst().val);
	}

	@Test
	public void testInsertionInBeginning() {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.insertFirst(2);
		assertNotNull(list.getFirst());
		assertEquals(2, list.getFirst().val);

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		assertThrows(NoSuchElementException.class, () -> {
			list2.getFirst();
		});
		list2.insertFirst(2);
		assertNotNull(list2.getFirst());
		assertEquals(2, list2.getFirst().val);
	}

	@Test
	public void testInsertionInEnd() {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.insertLast(2);
		assertEquals(2, list.getLast().val);
		list.insertLast(3);
		assertEquals(3, list.getLast().val);
	}

	@Test
	public void testInsertAtGivenPosition() {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.insertAtPos(212, 2);
		assertEquals(212, list.getNodeAtPos(2).val);
		list.insertAtPos(333, 3);
		list.insertAtPos(441, 1);
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertAtPos(67, 9);
		});
	}

	@Test
	public void testDeleteFirstNode() {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.deleteFirst();
		assertThrows(NoSuchElementException.class, () -> { list.getFirst(); });
		
		list.insertFirst(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);

		list.deleteFirst();
		assertEquals(2, list.getFirst().val);

		list.deleteFirst();
		assertEquals(3, list.getFirst().val);

		list.deleteFirst();
		list.deleteFirst();
		assertEquals(5, list.getFirst().val);
	}
	
	@Test
	public void testDeleteLastNode() {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertFirst(1);
		list.deleteLast();
		assertThrows(NoSuchElementException.class, () -> { list.getLast(); });
		
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		
		list.deleteLast();
		assertEquals(4, list.getLast().val);
	}
}
