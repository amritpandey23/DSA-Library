package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] boundary = {10, 3, 4, 5, 9, 2, 3, 9};
        System.out.println(trap(boundary)); 
    }

    public static int trap(int[] boundary) {
        int n = boundary.length;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        rightMax[n - 1] = boundary[n - 1];
        leftMax[0] = boundary[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], boundary[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], boundary[i]);
        }
        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            total += (Math.min(rightMax[i], leftMax[i]) - boundary[i]);
        }
        return total;
    }
}
