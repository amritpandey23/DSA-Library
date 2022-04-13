package dynamic_programming;

import java.util.*;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(lcs(s1, s2));
        sc.close();
    }

    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    /**
     * Iterative Solution
     * Returns the longest common subsequence string
     * @param String s1     String 1
     * @param String s2     String 2
     * @return longest subsequence string
     */
    public static String sequence(String s1, String s2) {
        int n, m;
        n = s1.length();
        m = s2.length();

        String[][] dp = new String[n + 1][m + 1];

        for (String[] a : dp) {
            Arrays.fill(a, "");
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    continue;  
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    } else {
                        dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ?
                                   dp[i][j - 1] : dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
