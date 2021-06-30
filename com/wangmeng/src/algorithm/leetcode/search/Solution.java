package algorithm.leetcode.search;

/**
 * @ClassName Solution
 * @Description dfs
 * @Author wangmeng
 * @Date 2021/3/26
 */
class Solution {

    public static void main(String[] args) {
        char[][] sfd = {{'a','b','c','e'}, {'s','f','c','s'},{'a','d','e','e'}};
        System.out.println(new Solution().exist(sfd, "bfce"));

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // start
                if (dfs(i, j, board, wordArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // dfs
    public boolean dfs(int m, int n, char[][] board, char[] word, int k) {
        if (m < 0 || m > board.length - 1 || n < 0 || n > board[0].length - 1) return false;
        if (board[m][n] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[m][n] = '/';
        int[][] DIRECTION = {{0,-1},{0,1},{-1,0},{1,0}};
        boolean flag = false;
        k = k + 1;
        for (int i = 0; i < DIRECTION.length; i++) {
            flag = dfs(m + DIRECTION[i][0], n + DIRECTION[i][1], board, word, k);
            if (flag) {
                board[m][n] = word[k];
                return true;
            }
        }
        board[m][n] = word[k - 1];
        return flag;
    }
}

