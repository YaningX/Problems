package leetcode.algorithms;

// https://oj.leetcode.com/problems/candy/
public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candy = new int[n];
    for (int i = 0; i < n; i++) {
      candy[i] = 1;
    }
    for (int i = 0; i < n - 1; i++) {
      if (ratings[i] < ratings[i + 1]) {
        candy[i + 1] = candy[i] + 1;
      }
    }
    for (int i = n - 1; i > 0; i--) {
      if (ratings[i - 1] > ratings[i]) {
        candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
      }
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += candy[i];
    }
    return sum;
  }
}
