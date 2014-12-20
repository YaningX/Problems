package leetcode;

// https://oj.leetcode.com/problems/edit-distance/
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length() + 1;
		int n = word2.length() + 1;
		int[][] dp = new int[m][n];
		for (int i = 1; i < m; i++)
			dp[i][0] = i;
		for (int j = 1; j < n; j++)
			dp[0][j] = j;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				int d = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
				dp[i][j] = Math.min(
						Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
						dp[i - 1][j - 1] + d);
			}
		return dp[m - 1][n - 1];
	}
}
