package com.amritpandey23.dsalibrary.tests.linkedlist;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.linkedlist.ListNode;

public class TestListNode {
	@Test
	public void testListNodeCreation() {
		ListNode<Integer> node = new ListNode<>(1);
		assertNotNull(node, "Node creation failed");
		
		node = new ListNode<>(1, node);
		assertNotNull(node.next, "Node creation does not set next node");
		assertEquals(1, node.next.val, "Value of next node is not correct");
	}
	
}
