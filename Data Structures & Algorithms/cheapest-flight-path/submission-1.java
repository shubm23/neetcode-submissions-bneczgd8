class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temPrices = Arrays.copyOf(prices, prices.length);
            for (int j = 0; j < flights.length; j++) {
                int source = flights[j][0], destination = flights[j][1], price = flights[j][2];
                if (prices[source] == Integer.MAX_VALUE) continue;
                if (prices[source] + price < temPrices[destination]) {
                    temPrices[destination] = prices[source] + price;
                }
            }
            prices = temPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
