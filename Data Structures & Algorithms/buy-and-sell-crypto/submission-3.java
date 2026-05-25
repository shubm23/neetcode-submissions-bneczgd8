class Solution {
    public int maxProfit(int[] prices) {
        int i = 0 , j = 1 , max = 0;
        while(j < prices.length){
            if(prices[i] > prices[j]){
                i = j;
            }
            int currProfit = prices[j] - prices[i];
            max = Math.max(max,currProfit);
            j++;
        }
        return max;
    }
}
