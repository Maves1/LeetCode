package T200;

public class T152 {
    public static int maxProduct(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = nums[0];
        postfix[n - 1] = nums[n - 1];

        int result = Math.max(prefix[0], postfix[n - 1]);

        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
            }

            int c = Math.max(prefix[i], nums[i]);
            if (c > result) result = c;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (postfix[i + 1] == 0) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = postfix[i + 1] * nums[i];
            }

            int c = Math.max(postfix[i], nums[i]);
            if (c > result) result = c;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-1, -2, -3, 0}));
    }
}
