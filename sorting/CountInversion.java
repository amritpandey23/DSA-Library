package sorting;

public class CountInversion {
    
    public static void main(String[] args) {
        int[] test = {5, 2, 1, 6, 8, 7, 5};
        System.out.println(count(test, 0, test.length - 1));
    }

    public static int count(int[] A, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            int res = count(A, l, m);
            res += count(A, m + 1, h);
            res += countAndMerge(A, l, m, h);
            return res;
        }
        return 0;
    }

    public static int countAndMerge(int[] A, int l, int m, int h) {
        int count = 0;
        int n1 = (m - l + 1);
        int n2 = (h - m);
        int[] right = new int[n2];
        int[] left = new int[n1];
        for (int i = 0; i < n1; i++) {
            left[i] = A[i + l];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = A[j + m + 1];
        }
        int i, j, k;
        i = j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
                count += (n1 - i);
            }
        }
        while (i < n1) {
            A[k++] = left[i++];
        }
        while (j < n2) {
            A[k++] = right[j++];
        }
        return count;
    }
}
