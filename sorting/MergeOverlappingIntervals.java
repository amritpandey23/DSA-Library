package sorting;
import java.util.*;
/*
author: @ok-ape
PS: Merge overlapping sub intervals
*/

/* test case:

6
7 9
6 10
4 5
1 3
2 4
11 15

*/

public class MergeOverlappingIntervals {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//code here
        int n = sc.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] p = new int[2];
            p[0] = sc.nextInt();
            p[1] = sc.nextInt();
            A[i] = p;
        }
        System.out.println("---");
        List<int[]> mergedList = merge(A);
        for (int[] p : mergedList) {
            print(p);
        }
	}

    public static List<int[]> merge(int[][] A) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(A, (p1, p2) -> p1[0] - p2[0]);
        int in, out;
        in = A[0][0];
        out = A[0][1];
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] <= out) {
                out = Math.max(A[i][1], out);
                continue;
            }
            res.add(new int[]{in, out});
            in = A[i][0];
            out = A[i][1];
        }
        if (res.get(res.size() - 1)[1] < in) {
            res.add(new int[]{in, out});
        }
        return res;
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
