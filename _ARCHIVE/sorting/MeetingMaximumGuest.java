package sorting;
import java.util.*;
/*
author: @ok-ape
PS: Maximum meeting guests, maximum classroom, maximum platforms
*/

/* test case:

6
1100 900 940 950 1500 1800
1130 910 1200 1120 1900 2000

*/

public class MeetingMaximumGuest {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dep = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			dep[i] = sc.nextInt();
		}
		System.out.println(maxGuestMeet(arr, dep));
	}

	public static int maxGuestMeet(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i, j, count, res;
		i = j = 0;
		count = 1;
		res = 1;
		while (i < arr.length && j < dep.length) {
			if (arr[i] < dep[j]) {
				i++;
				count++;
			} else {
				j++;
				count--;
			}
			res = Math.max(res, count);
		}
		return count;
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
