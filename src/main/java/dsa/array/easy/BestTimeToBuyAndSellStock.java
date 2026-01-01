package dsa.array.easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int minStockValue = prices[0];
        int maxProfit = 0;

        for (int i=1; i<prices.length; i++) {
            // if current stock is less than min stock value, update min stock value
            if(prices[i] < minStockValue) {
                minStockValue = prices[i];
            } else {
                // else we found a stock price greater than min stock value, calculate profit and update max profit if needed
                maxProfit = Math.max(maxProfit, prices[i] - minStockValue);
            }
        }

        return maxProfit;
    }
}
