package sorting;
import java.util.*;
/*
author: @ok-ape
PS: Sort three types of elements.
Trick: Use lomudo partition with two pivots
*/

/* test case:

8 5 10
5 8 9 10 1 2 11 12

*/

public class SortThreeTypeElements {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        int n, x, y;
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        sortAroundRange(A, x, y);
        print(A);
	}

    public static void sortAroundRange(int[] A, int x, int y) {
        int i, j;
        i = -1;
        j = 0;
        while (j < A.length) {
            if (A[j] < x) {
                i++;
                swap(A, i, j);
            }
            j++;
        }
        j = i;
        while (j < A.length) {
            if (A[j] >= x && A[j] <= y) {
                i++;
                swap(A, i, j);
            }
            j++;
        }
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
