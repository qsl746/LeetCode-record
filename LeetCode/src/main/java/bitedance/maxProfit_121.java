package bitedance;

public class maxProfit_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice=Integer.MAX_VALUE;
            int maxProfit=0;
            for (int price :
                    prices) {
                maxProfit = Math.max(maxProfit,price-minPrice);
                minPrice=Math.min(minPrice,price);
            }
            return maxProfit;
        }
    }
}
