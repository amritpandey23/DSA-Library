package dynamic_programming;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(lcs(s1, s2));
        sc.close();
    }

    public static int lcs(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return lcs(s1, s2, s1.length(), s2.length(), memo);
    }

    public static int lcs(String s1, String s2, int n, int m, int[][] memo) {
        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (n == 0 || m == 0) {
            memo[n][m] = 0;
        } else if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            memo[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, memo);
        } else {
            memo[n][m] = Math.max(lcs(s1, s2, n - 1, m, memo), lcs(s1, s2, n, m - 1, memo));
        }

        return memo[n][m];
    }
}
