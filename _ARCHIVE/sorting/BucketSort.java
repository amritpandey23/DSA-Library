package sorting;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {30, 40, 10, 80, 5, 12, 70};
        sort(nums, 4);
        for (int n : nums) {
            System.out.print(n + " "); 
        }
        System.out.println();
    }

    public static void sort(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }
        int maxVal = nums[0];
        for (int n : nums) {
            maxVal = Math.max(n, maxVal);
        }
        maxVal++; // either increment maxVal
        // k--;   // or decrement k value
        for (int n : nums) {
            int idx = (k * n) / maxVal;
            buckets.get(idx).add(n);
        }
        int i = 0;
        for (List<Integer> bkt : buckets) {
            Collections.sort(bkt);
            for (int a : bkt) {
                nums[i++] = a;
            }
        }
    }
}
