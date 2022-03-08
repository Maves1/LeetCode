package T200;

public class T122 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int currMinPrice = prices[0];
        int currProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {
                currProfit = prices[i] - currMinPrice;
            } else {
                maxProfit += currProfit;
                currProfit = 0;
                currMinPrice = prices[i];
            }

            if (prices[i] < currMinPrice) currMinPrice = prices[i];
        }

        if (currProfit != 0) maxProfit += currProfit;
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
