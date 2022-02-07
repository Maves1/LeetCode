package T1500;

import java.util.LinkedHashSet;

public class T1493 {

    public static int longestSubarray(int[] nums) {
        int n = nums.length;

        int[] counters = new int[n];
        int counter = 0;
        int lastZero = -1;

        int max = 0;

        LinkedHashSet<Integer> singleZeros = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                counter++;
                counters[i] = counter;

                if (singleZeros.contains(lastZero)) counters[lastZero + 1] = counter;

                if (counter > max) {
                    max = counter;
                }
            } else {
                if (lastZero != -1 && singleZeros.contains(lastZero)) {
                    counters[lastZero + 1] = counter;
                }

                lastZero = i;
                counter = 0;

                if (i < n - 1 && i > 0) {
                    if (nums[i - 1] == 1 && nums[i + 1] == 1) {
                        singleZeros.add(i);
                    }
                }
            }
        }

        for (int i : singleZeros) {
            if (counters[i - 1] + counters[i + 1] > max) max = counters[i - 1] + counters[i + 1];
        }

        if (lastZero == -1) max--;

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
    }
}
