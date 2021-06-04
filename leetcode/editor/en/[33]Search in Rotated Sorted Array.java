//There is an integer array nums sorted in ascending order (with distinct values
//). 
//
// Prior to being passed to your function, nums is rotated at an unknown pivot i
//ndex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+
//1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
//[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
//
// Given the array nums after the rotation and an integer target, return the ind
//ex of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// All values of nums are unique. 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 7935 👎 679


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length ;
        int cur1 = 0;
        int cur2 = length -1;
        while (cur1 < cur2) {
            int mid = (cur1 + cur2) /2;
            if (target ==  nums[mid]) return mid;
            if (nums[mid] >= nums[cur1]) {
                if (target < nums[mid] && target >= nums[cur1]){
                    cur2 = mid - 1;
                }else {
                    cur1 = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[cur2]){
                    cur1 = mid + 1;
                }else {
                    cur2 = mid - 1;
                }
            }
        }

        return nums[cur1] == target ? cur1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
