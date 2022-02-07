package T1100;

public class T1014 {

    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int p1 = 0;
        int p2 = 1;

        int maxScore = values[p1] + values[p2] - p2 + p1;

        if (n >= 3) {

            for (int i = 2; i < n; i++) {
                int firstScore = values[p1] + values[i] - i + p1;
                int secondScore = values[p2] + values[i] - i + p2;

                if (firstScore > secondScore) {
                    if (firstScore > maxScore) {
                        maxScore = firstScore;
                        p2 = i;
                    }
                } else {
                    if (secondScore >= maxScore) {
                        maxScore = secondScore;
                        p1 = p2;
                        p2 = i;
                    }
                }
            }

            return maxScore;
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{2,7,7,2,1,7,10,4,3,3}));
    }
}
