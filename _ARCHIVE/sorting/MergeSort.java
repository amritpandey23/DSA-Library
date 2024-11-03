package sorting;
import java.util.*;

/*
8
1 7 2 9 3 3 0 6
*/

public class MergeSort {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        } 
        sort(A, 0, A.length - 1);
        print(A);
    }

    public static void sort(int[] A, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            sort(A, l, m);
            sort(A, m + 1, h);
            merge(A, l, m, h);
        }
    }

    public static void merge(int[] A, int l, int m, int h) {
        int n1, n2;
        n1 = (m - l + 1);               // length of right array
        n2 = h - m;                     // length of left array
        int[] right = new int[n1];
        int[] left = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = A[i + l];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = A[i + m + 1];
        }
        int i, j, k;
        i = j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        // System.out.println("k = " + k + ", i = " + i + ", j = " + j);
        // System.out.println("l = " + l + "h = " + h);
        while (i < n1) {
            A[k++] = left[i++];
        }
        while (j < n2) {
            A[k++] = right[j++];
        }
    }

    static void print(int[] A) {
        for (int n : A) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
