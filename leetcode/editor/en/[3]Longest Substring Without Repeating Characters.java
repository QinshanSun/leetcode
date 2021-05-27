//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 14592 👎 747


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){return 0;}
        int[] positions = new int[128];
        int startFrom = 0;
        int max = 0;
        int cur = 0;
        for(int endIn = 0; endIn < s.length(); endIn++){
            if(positions[s.charAt(endIn)] == 0){
                positions[s.charAt(endIn)] = endIn + 1;
                // we add 1 so that character whose position is 0 would not conflict with character not in the HashSet.
                cur++;
                if(cur > max){max = cur;}
            }
            else{
                int index = positions[s.charAt(endIn)] - 1;
                while(startFrom <= index){
                    positions[s.charAt(startFrom)] = 0;
                    startFrom++;
                }
                cur = endIn - startFrom + 1;
                positions[s.charAt(endIn)] = endIn + 1;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
