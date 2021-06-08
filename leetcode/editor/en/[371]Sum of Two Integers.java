//Given two integers a and b, return the sum of the two integers without using t
//he operators + and -. 
//
// 
// Example 1: 
// Input: a = 1, b = 2
//Output: 3
// Example 2: 
// Input: a = 2, b = 3
//Output: 5
// 
// 
// Constraints: 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics Bit Manipulation 
// 👍 1745 👎 2818


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
