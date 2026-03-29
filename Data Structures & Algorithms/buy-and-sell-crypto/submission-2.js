class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
      let i = 0 , j = 1, max = 0;
      while(j < prices.length){
        if(prices[i] > prices[j]){
          i = j;
        }
        const currMax = prices[j] - prices[i];
        max = Math.max(max,currMax);
        j++;
      }
      return max;
    }
}

