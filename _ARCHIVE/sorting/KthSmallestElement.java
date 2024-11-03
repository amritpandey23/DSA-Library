package sorting;
import java.util.*;

/*
// only works on distinct elements
8 3
8 7 1 2 3 4 5 6
*/

public class KthSmallestElement {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(kthSmallest(A, k));
    }

    public static int kthSmallest(int[] A, int k) {
        int l, h;
        l = 0;
        h = A.length - 1;
        while (l <= h) {
            int m = partition(A, l, h);
            if (m == k - 1) {
                return A[m];
            }
            if (m > k - 1) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static int partition(int[] A, int l, int h) {
        // lomudo's partition
        int i, j, pivot;
        i = l - 1;
        j = l;
        pivot = A[h];
        while (j < h) {
            if (A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
            j++;
        }
        i++;
        swap(A, i, h);
        return i;
    }

    public static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
