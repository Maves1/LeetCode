package T800;

import java.util.*;

public class T740 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> quants = new HashMap<>();
        SortedSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (!quants.containsKey(i)) {
                quants.put(i, 0);
                set.add(i);
            }
            quants.put(i, quants.get(i) + 1);
        }

        int n = set.size();
        int[] dp = new int[n];
        int prevNumber = set.first();
        dp[0] = prevNumber * quants.get(prevNumber);
        set.remove(prevNumber);

        int i = 1;
        for (int currNumber : set) {
            if (currNumber - prevNumber > 1) {
                dp[i] = dp[i - 1] + currNumber * quants.get(currNumber);
            } else {
                if (i > 1) {
                    dp[i] = Math.max(currNumber * quants.get(currNumber) + dp[i - 2], dp[i - 1]);
                } else {
                    dp[i] = Math.max(currNumber * quants.get(currNumber), dp[i - 1]);
                }
            }

            i++;
            prevNumber = currNumber;
        }

        return dp[n - 1];
    }
}
