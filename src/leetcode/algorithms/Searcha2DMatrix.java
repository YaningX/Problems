package leetcode.algorithms;

// https://leetcode.com/problems/search-a-2d-matrix/
public class Searcha2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) {
      return false;
    }
    int n = matrix[0].length;
    int low = 0, high = m * n - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      int r = mid / n;
      int c = mid % n;
      if (matrix[r][c] == target) {
        return true;
      } else if (matrix[r][c] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}
