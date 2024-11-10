package com.amritpandey23.dsalibrary.tests.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.linkedlist.DoublyListNode;

public class TestDoublyListNode {
	@Test
	public void testCreationOfDoublyListNode() {
		DoublyListNode<Integer> dln = new DoublyListNode<>(1);
		
		assertNull(dln.next);
		assertNull(dln.prev);
		assertEquals(1, dln.val);
		
		DoublyListNode<Integer> dlnPrev = new DoublyListNode<>(2);
		DoublyListNode<Integer> dlnNext = new DoublyListNode<>(3);
		
		dln = new DoublyListNode<>(1, dlnPrev, dlnNext);
		
		assertNotNull(dln.next);
		assertNotNull(dln.prev);
		assertEquals(1, dln.val);
	}
}
