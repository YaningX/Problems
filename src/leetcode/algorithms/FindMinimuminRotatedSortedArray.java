package leetcode.algorithms;

// https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimuminRotatedSortedArray {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return nums[low];
  }
}
