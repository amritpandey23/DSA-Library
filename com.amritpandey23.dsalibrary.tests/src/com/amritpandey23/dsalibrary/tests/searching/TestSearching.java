package com.amritpandey23.dsalibrary.tests.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.amritpandey23.dsalibrary.searching.Utilities;

public class TestSearching {
	@Test
	public void testCombinationUtility() {
		Integer[] myNumbers = { 1, 1, 3, 1 };
		List<List<Integer>> subsets = Utilities.generateSubset(myNumbers);
//		System.out.println(subsets);
		assertEquals(16, Utilities.generateSubset(myNumbers).size());
		assertTrue(subsets.contains(Arrays.asList(new Integer[] { 1, 1, 3, 1 })));
		assertTrue(subsets.contains(Arrays.asList(new Integer[] {})));
		assertTrue(subsets.contains(Arrays.asList(new Integer[] { 3 })));
	}

	@Test
	public void testPermutationUtility() {
		Integer[] myNumbers = { 1, 2, 3 };
		List<List<Integer>> permutations = Utilities.generatePermutations(myNumbers);
//		System.out.println(permutations);
		assertEquals(6, permutations.size());
		assertTrue(permutations.contains(Arrays.asList(new Integer[] { 1, 2, 3 })));
		assertTrue(permutations.contains(Arrays.asList(new Integer[] { 3, 1, 2 })));
		assertTrue(permutations.contains(Arrays.asList(new Integer[] { 2, 1, 3 })));
	}
	
	@Test
	public void testBinarySearchUtility() {
		int[] myNumbers = {1, 2, 3, 4, 5, 6};
		
		assertEquals(-1, Utilities.binarySearch(myNumbers, -1));
		assertEquals(1, Utilities.binarySearch(myNumbers, 2));
	}
	
	@Test
	public void testFirstOccuranceInSortedArray() {
		int[] myNumbers = {1, 1, 1, 4, 5, 6};
		
		assertEquals(-1, Utilities.firstOccuranceInSortedArray(myNumbers, -1));
		assertEquals(0, Utilities.firstOccuranceInSortedArray(myNumbers, 1));
		assertEquals(3, Utilities.firstOccuranceInSortedArray(myNumbers, 4));
	}
}
