//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 5847 👎 210


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);
    return result;
  }

  private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
      int mid = (start + end) / 2;
      if(nums[mid] >= target){
        end = mid - 1;
      }else{
        start = mid + 1;
      }
      if(nums[mid] == target) idx = mid;
    }
    return idx;
  }

  private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
      int mid = (start + end) / 2;
      if(nums[mid] <= target){
        start = mid + 1;
      }else{
        end = mid - 1;
      }
      if(nums[mid] == target) idx = mid;
    }
    return idx;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
