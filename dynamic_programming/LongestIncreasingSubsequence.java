package dynamic_programming;

/* test case

8
4 10 6 5 8 11 2 20

*/

/*
Longest Increasing subsequence: find out the subsequence that is longest increasing.

Approach 1:
For any element X in the array, if we can find element Y which is occuring before X
and Y < X, then the length of longest increasing subsequence till Y + 1 will be the
answer for longest increasing subsequence for X. We can do this for all Ys occuring
before X in the array.

LIS: | 1 | 2 | 2 | 2 | 3 | 4 | 1 | 5 |
Arr: | 4 | 10| 6 | 5 | 8 |11 | 2 |20 |

Approach 2:
We can create a tail array to store elements in the array. Before inserting element
to the tail array we are going to check if it's greater than last element, if it is
then we are going to insert it into the array else we are going to replace the ceil
value of this element in the array. This way the length of the array is going to
increase for strictly increasing values.
*/

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