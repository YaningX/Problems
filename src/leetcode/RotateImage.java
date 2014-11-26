package leetcode;

// https://oj.leetcode.com/problems/rotate-image/
public class RotateImage
{
	public void rotate(int[][] matrix)
	{
		int len = matrix.length;
		for (int i = 0; i < len / 2; i++)
			for (int j = i; j < len - i - 1; j++)
			{
				int t = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = t;
			}
	}
}