public class Problem2 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        // Single pass through the prices array
        for (int i = 1; i < prices.length; i++) {
            // Track lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today and update max profit
                int profitToday = prices[i] - minPrice;
                if (profitToday > maxProfit) {
                    maxProfit = profitToday;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output: 5
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));    // Output: 0
    }
}