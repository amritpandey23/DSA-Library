/**
 * Provides utility methods for generating subsets and permutations of an array, as well as searching operations.
 *
 * @param <T> The type of elements in the input array.
 */
package com.amritpandey23.dsalibrary.searching;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

	/**
	 * Generates all possible subsets of a given array.
	 *
	 * @param <T> The type of elements in the array.
	 * @param arr The input array for which subsets need to be generated.
	 * @return A list of lists, where each inner list is a subset of the input
	 *         array.
	 */
	public static <T> List<List<T>> generateSubset(T[] arr) {
		List<List<T>> Ans = new ArrayList<>();
		List<T> subset = new ArrayList<>();
		combination(arr, 0, subset, Ans);
		return Ans;
	}

	/**
	 * Generates all possible permutations of a given array.
	 *
	 * @param <T> The type of elements in the array.
	 * @param arr The input array for which permutations need to be generated.
	 * @return A list of lists, where each inner list is a permutation of the input
	 *         array.
	 */
	public static <T> List<List<T>> generatePermutations(T[] arr) {
		List<List<T>> Ans = new ArrayList<>();
		List<T> permuationSet = new ArrayList<>();
		boolean[] picked = new boolean[arr.length];
		permutation(arr, picked, permuationSet, Ans);
		return Ans;
	}

	/**
	 * Recursive helper method to generate all subsets of the given array.
	 *
	 * @param <T>    The type of elements in the array.
	 * @param arr    The input array for which subsets are generated.
	 * @param k      The current index in the array.
	 * @param subset The current subset being built.
	 * @param Ans    The final list of subsets to store results.
	 */
	private static <T> void combination(T[] arr, int k, List<T> subset, List<List<T>> Ans) {
		if (k == arr.length) {
			List<T> sub = new ArrayList<>(subset);
			Ans.add(sub);
		} else {
			combination(arr, k + 1, subset, Ans);
			subset.add(arr[k]);
			combination(arr, k + 1, subset, Ans);
			subset.remove(arr[k]);
		}
	}

	/**
	 * Recursive helper method to generate all permutations of the given array.
	 *
	 * @param <T>            The type of elements in the array.
	 * @param arr            The input array for which permutations are generated.
	 * @param picked         An array indicating whether an element has been picked
	 *                       for the current permutation.
	 * @param permutationSet The current permutation being built.
	 * @param Ans            The final list of permutations to store results.
	 */
	private static <T> void permutation(T[] arr, boolean[] picked, List<T> permutationSet, List<List<T>> Ans) {
		if (permutationSet.size() == arr.length) {
			Ans.add(new ArrayList<T>(permutationSet));
		} else {
			for (int i = 0; i < arr.length; ++i) {
				if (picked[i]) {
					continue;
				}
				picked[i] = true;
				permutationSet.add(arr[i]);
				permutation(arr, picked, permutationSet, Ans);
				picked[i] = false;
				permutationSet.remove(arr[i]);
			}
		}
	}

	/**
	 * Performs binary search on a sorted array to find the index of a specified
	 * element.
	 *
	 * @param A the sorted array in which to search
	 * @param x the element to search for
	 * @return the index of the element if found, otherwise -1
	 */
	public static int binarySearch(int[] A, int x) {
		int high, mid, low;

		low = 0;
		high = A.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == x) {
				return mid;
			} else if (A[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Finds the first occurrence of a specified element in a sorted array.
	 *
	 * @param A the sorted array in which to search
	 * @param x the element to search for
	 * @return the index of the first occurrence of the element if found, otherwise
	 *         -1
	 */
	public static int firstOccuranceInSortedArray(int[] A, int x) {
		int high, mid, low;

		low = 0;
		high = A.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] == x) {
				if (mid == 0 || A[mid - 1] != x) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (A[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
