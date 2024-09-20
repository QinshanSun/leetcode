//Given a string expression of numbers and operators, return all possible 
//results from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// The test cases are generated such that the output values fit in a 32-bit 
//integer and the number of different results does not exceed 10⁴. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// All the integer values in the input expression are in the range [0, 99]. 
// The integer values in the input expression do not have a leading '-' or '+' 
//denoting the sign. 
// 
//
// Related Topics Math String Dynamic Programming Recursion Memoization 👍 5695 
//👎 322


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.indexOf('+') == -1 && expression.indexOf('-') == -1 && expression.indexOf('*') == -1) {
                res.add(Integer.parseInt(expression));
                return res;
            }

            char c = expression.charAt(i);
            List<Integer> left;
            left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right;
            right = diffWaysToCompute(expression.substring(i + 1));
            for (int a : left) {
                for (int b : right) {
                    res.add(calculate(c, a, b));
                }
            }
        }
        return res;
    }

    private Integer calculate(char operator, int a, int b) {
      return switch (operator) {
        case '+' -> a + b;
        case '-' -> a - b;
        case '*' -> a * b;
        default -> 0;
      };
    }
}
//leetcode submit region end(Prohibit modification and deletion)