package DP.One;

public class DP918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int max = dpMax[0];
        int min = dpMin[0];
        int sum = nums[0];

        for (int i = 1; i < n; i++) {
            sum += nums[i];

            int firstMax = dpMax[i - 1] + nums[i];
            int secondMax = nums[i];
            
            if (firstMax > secondMax) {
                dpMax[i] = firstMax;
            } else {
                dpMax[i] = secondMax;
            }

            if (dpMax[i] > max) {
                max = dpMax[i];
            }

            int firstMin = dpMin[i - 1] + nums[i];
            int secondMin = nums[i];

            if (firstMin > secondMin) {
                dpMin[i] = secondMin;
            } else {
                dpMin[i] = firstMin;
            }

            if (dpMin[i] < min) {
                min = dpMin[i];
            }
        }

        if (sum == min) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, 4, -3, 7}));
    }
}
