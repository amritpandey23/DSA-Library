package sorting;
import java.util.*;
/*
author: @okape
PS:
*/

/* test case:

8 5
3 4 1 9 56 7 9 12

*/

public class ChocolateDistribution {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] bags = new int[n];
        for (int i = 0; i < n; i++) {
            bags[i] = sc.nextInt();
        }
        System.out.println("minimum difference = " + minDiff(bags, k));
	}

    public static int minDiff(int[] bags, int k) {
        Arrays.sort(bags);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < bags.length - k + 1; i++) {
            diff = Math.min(diff, bags[i + k - 1] - bags[i]);
        }
        return diff;
    }

	public static void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}

	public static void print(int[] A) {
		for (int n : A) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
