package T1600;

public class T1567 {
    public static int getMaxLen(int[] nums) {
        int n = nums.length;

        boolean isPositive = nums[0] >= 0;
        int currLength = nums[0] == 0 ? 0 : 1;
        int maxLength = currLength;

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                currLength++;
                if (currLength > maxLength && isPositive) maxLength = currLength;
            } else if (nums[i] < 0) {
                isPositive = !isPositive;
                currLength++;
                if (currLength > maxLength && isPositive) maxLength = currLength;
            } else {
                isPositive = true;
                currLength = 0;
            }
        }

        currLength = nums[n - 1] == 0 ? 0 : 1;
        if (currLength > maxLength) maxLength = currLength;
        isPositive = nums[n - 1] >= 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > 0) {
                currLength++;
                if (currLength > maxLength && isPositive) maxLength = currLength;
            } else if (nums[i] < 0) {
                isPositive = !isPositive;
                currLength++;
                if (currLength > maxLength && isPositive) maxLength = currLength;
            } else {
                isPositive = true;
                currLength = 0;
            }
        }

        if (n == 1 && nums[0] < 0) maxLength = 0;

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{-1,2}));
    }
}
