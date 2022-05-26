package sorting;
import java.util.*;
/*
author: @ok-ape
PS:
*/

/* test case:

8 5 10
5 8 9 10 1 2 11 12

*/

public class DutchNationalFlag {
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
        /* bookish solution */
        int hi, lo, mid;
        lo = mid = 0;
        hi = A.length - 1;
        while (mid <= hi) {
            if (A[mid] < x) {
                swap(A, lo, mid);
                mid++;
                lo++;
            } else if (A[mid] > y) {
                swap(A, mid, hi);
                hi--;
            } else {
                mid++;
            }
        }
    }

    public static void sortAroundRange2(int[] A, int x, int y) {
        /* this is an intuitive solution
        designed by me. NOT WORKING
        */
        int l, h, m;
        l = m = -1;
        h = A.length;
        while (true) {
            do {l++;} while (A[l] < x);
            do {m++;} while (A[m] >= x && A[m] <= y);
            do {h--;} while (A[h] > y);
            if (m >= h && l >= h) {
                return;
            }
            if (A[m] < x) {
                swap(A, l, m);
            } else {
                swap(A, h, m);
            } 
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
