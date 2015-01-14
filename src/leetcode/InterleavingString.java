package leetcode;

// https://oj.leetcode.com/problems/interleaving-string/
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int m = s1.length() + 1;
		int n = s2.length() + 1;
		boolean[][] dp = new boolean[m][n];
		dp[0][0] = true;
		for (int i = 1; i < m; i++)
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		for (int j = 1; j < n; j++)
			dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1
						+ j))
						|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j
								- 1));
		return dp[m - 1][n - 1];
	}
}