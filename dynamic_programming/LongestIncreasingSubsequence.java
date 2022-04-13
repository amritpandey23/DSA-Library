package dynamic_programming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test = {8, 100, 150, 10, 12, 14, 110};
        System.out.println("LIS = " + lis2(test));
    }

    public static int lis2(int[] nums) {
        int[] tail = new int[nums.length];
        int len = 1;

        tail[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[len - 1]) {
                tail[len] = nums[i];
                len++;
            } else {
                int ceilIdx = ceil(tail, 0, len, nums[i]);
                tail[ceilIdx] = nums[i];
            }
        }

        return len;
    }

    public static int ceil(int[] tail, int l, int h, int val) {
        while (l < h) {
            int mid = (l + h) / 2;
            if (tail[mid] >= val) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static int lis1(int[] nums) {
        int[] lis = new int[nums.length];

        lis[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int res = 0;

        for (int a : lis) {
            res = Math.max(res, a);
        }

        return res;
    }
}