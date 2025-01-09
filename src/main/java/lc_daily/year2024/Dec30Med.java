package lc_daily.year2024;

import java.util.HashMap;
import java.util.Map;

public class Dec30Med {
    public void solve() {
        System.out.println(countGoodStrings(3, 3, 1, 1));
        cnt = 0;
//        System.out.println();
        System.out.println(countGoodStrings(2, 3, 1, 2));
    }

    public int countGoodStrings(int low, int high, int noZero, int noOne) {
        // dp[i] will store the number of good strings of length i
        int[] dp = new int[high + 1];

        // Base case: There is 1 good string of length 0 (the empty string)
        dp[0] = 1;

        // Fill the dp array from 1 to high
        for (int i = 1; i <= high; i++) {
            // Add "0".repeat(noZero) if i >= noZero
            if (i >= noZero) {
                dp[i] += dp[i - noZero];
            }
            // Add "1".repeat(noOne) if i >= noOne
            if (i >= noOne) {
                dp[i] += dp[i - noOne];
            }
            dp[i] %= 1_000_000_007;
        }

        // Count good strings whose lengths are between low and high
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            cnt += dp[i];
            cnt %= 1_000_000_007;
        }

        return cnt;
    }


    private static int cnt = 0;
    private Map<String, Integer> memo = new HashMap<>();

//    public int countGoodStrings(int low, int high, int noZero, int noOne) {
//        cnt = 0;
//        memo.clear(); // Clear memo for each call
//        count("", low, high, noZero, noOne);
//        return cnt;
//    }

    private void count(String s, int low, int high, int noZero, int noOne) {
        if (s.length() > high) return;

        // Check memoized results
        if (memo.containsKey(s)) {
            cnt += memo.get(s);
            return;
        }

        int currentCount = isGoodString(s, low, high); // Check if current string is "good"
        cnt += currentCount;

        // Recursive calls with added "0" and "1" patterns
        count("0".repeat(noZero) + s, low, high, noZero, noOne);
        count("1".repeat(noOne) + s, low, high, noZero, noOne);

        // Store the result in the memo
        memo.put(s, currentCount);
    }

    private int isGoodString(String s, int min, int max) {
        if (s.length() >= min && s.length() <= max) {
            return 1;
        }
        return 0;
    }
}
