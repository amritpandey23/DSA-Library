package com.amritpandey23.dsalibrary.tests.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.linkedlist.DoublyLinkedList;

public class TestDoublyLinkedList {
	@Test
	public void testCreationOfDoublyLinkedList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> { list.getFirst(); });
		
		list.insertLast(1);
		assertEquals(1, list.getFirst().val);
	}
}
