package sorting;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:

8
1 10 9 2 3 4 5 -1

*/

public class MinimumDifferenceInArray {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(minDiff(A));
	}

    public static int minDiff(int[] A) {
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            diff = Integer.min(diff, A[i] - A[i - 1]);
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
