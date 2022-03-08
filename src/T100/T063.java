package T100;

public class T063 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0 && obstacleGrid[i - 1][j] != 1 && j > 0 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] field = new int[3][3];

        System.out.println(uniquePathsWithObstacles(field));
    }
}
