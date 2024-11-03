package matrices;

import java.util.Arrays;

public class MedianInRowSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 10, 20 },
                { 15, 25, 35 },
                { 5, 30, 40 }
        };
        System.out.println(findMedian(matrix));
    }

    public static int findMedian(int[][] mat) {
        int min, max;
        final int H, W, medPos;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        H = mat.length;
        W = mat[0].length;
        medPos = (H * W) / 2;
        for (int row = 0; row < H; row++) {
            min = Math.min(min, mat[row][0]);
            max = Math.max(max, mat[row][W - 1]);
        }
        while (min < max) {
            int mid = (max + min) / 2;
            int pos = 0;
            for (int row = 0; row < H; row++) {
                int p = Arrays.binarySearch(mat[row], mid) + 1;
                pos += Math.abs(p);
            }
            if (pos > medPos) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
