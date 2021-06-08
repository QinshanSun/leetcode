//Given an m x n grid of characters board and a string word, return true if word
// exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e adjacent cells are horizontally or vertically neighboring. The same letter cel
//l may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a l
//arger board? 
// Related Topics Array Backtracking 
// 👍 5887 👎 246


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArray[0] && searchChar(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchChar(char[][] board, char[] wordArray, int m, int n, int start) {
        if(start == wordArray.length)
            return true;
        if (m >= board.length || n >= board[0].length || m < 0 || n < 0 || board[m][n] == '0'  || board[m][n] != wordArray[start])
            return false;

        char tmp = board[m][n];
        board[m][n] = '0';


        if(searchChar(board, wordArray, m - 1, n, start + 1) ||
                searchChar(board, wordArray, m + 1, n, start + 1) ||
                searchChar(board, wordArray, m, n + 1, start + 1) ||
                searchChar(board, wordArray, m, n - 1, start + 1)){
            return true;
        }

        board[m][n] = tmp;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
