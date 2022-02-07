package T100;

import java.util.PriorityQueue;

public class T004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] combined = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                combined[i] = nums1[p1];
                p1++;
            } else {
                combined[i] = nums2[p2];
                p2++;
            }

            i++;
        }

        if (p1 < nums1.length) {
            while (i < combined.length) {
                combined[i] = nums1[p1];
                p1++;
                i++;
            }
        } else if (p2 < nums2.length) {
            while (i < combined.length) {
                combined[i] = nums2[p2];
                p2++;
                i++;
            }
        }

        if (combined.length % 2 != 0) {
            return combined[combined.length / 2];
        } else {
            return ((float) combined[combined.length / 2 - 1] + combined[combined.length / 2 ]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
