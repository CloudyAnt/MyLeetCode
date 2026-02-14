package cn.itscloudy.mylc.hard;

// LeetCode 123
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        var buy1 = -prices[0];
        int buy2 = -prices[0];
        var sell1 = 0;
        var sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
