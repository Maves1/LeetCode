package T100;

import java.util.HashMap;
import java.util.Map;

public class T003 {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        char[] array = s.toCharArray();

        Map<Character, Integer> indices = new HashMap<>();

        int n = array.length;
        int max = 0;

        int l = 0;
        int r = 0;

        while (r < n) {
            char curr = array[r];
            if (!indices.containsKey(curr)) {
                indices.put(curr, r);
                if (r - l > max) max = r - l;
            } else {
                l = indices.get(curr) + 1;
                r = l;
                indices.clear();
                indices.put(array[l], l);
            }
            r++;

        }

        return max + 1;

    }

}
