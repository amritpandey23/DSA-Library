package sorting;

public class QuickSortLP {
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
            int m = lomudoPartition(A, l, h);
            sort(A, l, m - 1);
            sort(A, m + 1, h);
        }
    }

    public static int lomudoPartition(int[] A, int l, int h) {
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
