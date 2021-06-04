//Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table 
// 👍 7541 👎 256


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = 1; end < sum.length; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
