package sorting;

public class QuickSortHP {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 8, 0, 5, 6, 90, 0};
        sort(A, 0, A.length - 1);  
        for (int n : A) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void sort(int[] A, int l, int h) {
        if (l < h) {
            int m = hoarePartition(A, l, h);

            sort(A, l, m);
            sort(A, m + 1, h);
        }
    }

    public static int hoarePartition(int[] A, int l, int h) {
        int i, j, pivot;
        pivot = A[l];
        i = l - 1;
        j = h + 1;
        while (true) {
            do {
                i++;
            } while (A[i] < pivot);
            do {
                j--;
            } while (A[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(A, i, j);
        }
    }

    public static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
