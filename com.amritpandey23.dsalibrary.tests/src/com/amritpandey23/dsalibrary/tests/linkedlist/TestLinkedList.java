package com.amritpandey23.dsalibrary.tests.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.linkedlist.LinkedList;
import com.amritpandey23.dsalibrary.linkedlist.List;

public class TestLinkedList {
	@Test
	public void testLinkedListCreation() {
		List<Integer> list = new LinkedList<>();
		assertNotNull(list);

		list = new LinkedList<Integer>(1);
		assertNotNull(list);
		assertNotNull(list.getFirst());
		assertEquals(1, list.getFirst().getValue());
	}

	@Test
	public void testInsertionInBeginning() {
		List<Integer> list = new LinkedList<>(1);
		list.insertFirst(2);
		assertNotNull(list.getFirst());
		assertEquals(2, list.getFirst().getValue());

		List<Integer> list2 = new LinkedList<Integer>();
		assertThrows(NoSuchElementException.class, () -> {
			list2.getFirst();
		});
		list2.insertFirst(2);
		assertNotNull(list2.getFirst());
		assertEquals(2, list2.getFirst().getValue());
	}

	@Test
	public void testInsertionInEnd() {
		List<Integer> list = new LinkedList<>(1);
		list.insertLast(2);
		assertEquals(2, list.getLast().getValue());
		list.insertLast(3);
		assertEquals(3, list.getLast().getValue());
	}

	@Test
	public void testInsertAtGivenPosition() {
		List<Integer> list = new LinkedList<>(1);
		list.insertAtPos(212, 2);
		assertEquals(212, list.getNodeAtPos(2).getValue());
		list.insertAtPos(333, 3);
		list.insertAtPos(441, 1);
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertAtPos(67, 9);
		});
	}

	@Test
	public void testDeleteFirstNode() {
		List<Integer> list = new LinkedList<>(1);
		list.deleteFirst();
		assertThrows(NoSuchElementException.class, () -> { list.getFirst(); });
		
		list.insertFirst(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);

		list.deleteFirst();
		assertEquals(2, list.getFirst().getValue());

		list.deleteFirst();
		assertEquals(3, list.getFirst().getValue());

		list.deleteFirst();
		list.deleteFirst();
		assertEquals(5, list.getFirst().getValue());
	}
	
	@Test
	public void testDeleteLastNode() {
		List<Integer> list = new LinkedList<>();
		list.insertFirst(1);
		list.deleteLast();
		assertThrows(NoSuchElementException.class, () -> { list.getLast(); });
		
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		
		list.deleteLast();
		assertEquals(4, list.getLast().getValue());
	}
	
	@Test
	public void testSearch() {
		List<Integer> list = new LinkedList<>();
		assertFalse(list.search(0));
		list.insertFirst(1);
		list.insertLast(2);
		
		assertFalse(list.search(3));
		
		assertTrue(list.search(2));
		list.deleteLast();
		assertFalse(list.search(2));
	}
	
	@Test
	public void testSearchRecursively() {
		LinkedList<Integer> list = new LinkedList<>();
		assertFalse(list.searchRecursively(0));
		list.insertFirst(1);
		list.insertLast(2);
		
		assertFalse(list.searchRecursively(3));
		
		assertTrue(list.searchRecursively(2));
		list.deleteLast();
		assertFalse(list.searchRecursively(2));
	}
	
	@Test
	public void testLoopInANode() {
		LinkedList<Integer> nonLoopyList = new LinkedList<>(1);
		nonLoopyList.insertLast(2);
		nonLoopyList.insertLast(3);
		nonLoopyList.insertLast(4);
		assertNull(nonLoopyList.findLoopNode());

		LinkedList<Integer> loopyList = new LinkedList<>(1);
		loopyList.insertLast(2);
		loopyList.insertLast(3);
		loopyList.insertLast(4);
		loopyList.getLast().next = loopyList.getFirst();
		assertNotNull(loopyList.findLoopNode());
	}
	
	@Test
	public void testLinkedListReversal() {
		LinkedList<Integer> list = new LinkedList<>(1);
		list.insertLast(2);
		list.insertLast(3);
		
		list.reverse();
		assertEquals(3, list.getFirst().getValue());
//		list.print();
	}
}
