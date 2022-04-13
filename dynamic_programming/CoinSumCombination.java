package dynamic_programming;

public class CoinSumCombination {
    public static void main(String[] args) {
        int[] coins = {5, 6, 7};
        int sum = 45;
        System.out.println("Total ways to pay = " + getCountRecursive(coins, sum, coins.length));
        System.out.println("Total ways to pay = " + getCountIterative(coins, sum, coins.length));
    }

    /**
     * Recursive Solution
     * Returns total number of ways (combination) to pay
     * an amount (sum) using infinite supply of N coins[].
     * @param   coins[]     different types of coins
     * @param   sum         net amount to pay
     * @param   n           total types of coins (n = coins.length)
     * @return              total ways to pay
     */
    public static int getCountRecursive(int[] coins, int sum, int n) {

        // BASE CASE:
        // if the total amount to pay
        // is zero then there's only
        // one way to pay.
        if (sum == 0) {
            return 1;
        }

        // BASE CASE:
        // if no coins are left then we
        // cannot pay.
        if (n == 0) {
            return 0;
        }

        // do not pick current coin and
        // pay using rest of the coins
        int ways = getCountRecursive(coins, sum, n - 1);

        // if you can pick current coin
        // then try to pay using it.
        if (coins[n - 1] <= sum) {
            ways += getCountRecursive(coins, sum - coins[n - 1], n); // infinite supply
        }

        return ways;
    }

    /**
     * Iterative Solution
     * Returns total number of ways to pay
     * amount (sum) using coins of n types coins[]
     * @param   coins[]     types of coins
     * @param   sum         amount to pay
     * @param   n           total types of coins
     * @return              total ways to pay
     */
    public static int getCountIterative(int[] coins, int sum, int n) {
        
        // a lookup dictionary to store ways
        // to pay for each amount (0 ... sum)
        // change of two variables: sum, n
        int[][] dp = new int[n + 1][sum + 1];

        for (int coin_type = 0; coin_type <= n; coin_type++) {
            for (int amt = 0; amt <= sum; amt++) {
                if (coin_type == 0 && amt == 0) {
                    // with no coins we can pay a sum
                    // of 0 in 1 way
                    dp[coin_type][amt] = 1;
                } else if (coin_type == 0) {
                    // with no coins we cannot pay
                    // a sum > 0
                    dp[coin_type][amt] = 0;
                } else if (amt == 0) {
                    // with some coins we can always
                    // pay a sum of 0
                    dp[coin_type][amt] = 1;
                } else {
                    // total ways to pay the sum with coins
                    // previous to this coin
                    dp[coin_type][amt] = dp[coin_type - 1][amt];
                    if (amt >= coins[coin_type - 1]) {
                        // only if the current coin is less
                        // than the required sum then pay
                        // it using this coin
                        dp[coin_type][amt] += dp[coin_type][amt - coins[coin_type - 1]];
                    }
                }
            }
        }

        // returning ways to pay sum using n coins
        return dp[n][sum];
    }
}