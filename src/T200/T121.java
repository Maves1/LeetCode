package T200;

public class T121 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > minPrice) {
                if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
            }
            if (prices[i] < minPrice) minPrice = prices[i];
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
