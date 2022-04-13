package dynamic_programming;

import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println("Edit Distance = " + editDistanceMemo(s1, s2, s1.length(), s2.length()));
        System.out.println("Edit Distance = " + editDistanceIterative(s1, s2, s1.length(), s2.length()));
        sc.close();
    }

    public static int editDistanceIterative(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }

    public static int editDistanceMemo(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return editDistanceMemo(s1, s2, n, m, dp);
    }

    public static int editDistanceMemo(String s1, String s2, int n, int m, int[][] dp) {
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (n == 0) {
            dp[n][m] = m;
        } else if (m == 0) {
            dp[n][m] = n;
        } else if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = editDistanceMemo(s1, s2, n - 1, m - 1);
        } else {
            dp[n][m] = 1 + Math.min(
                    editDistanceMemo(s1, s2, n, m - 1),
                    Math.min(
                            editDistanceMemo(s1, s2, n - 1, m),
                            editDistanceMemo(s1, s2, n - 1, m - 1)));
        }

        return dp[n][m];
    }
}
