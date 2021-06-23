package com.leetcode.search;

/**
 * @ClassName Souluton2
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/3/27
 */
class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().movingCount(16,8 , 4));

    }

    int count = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, k)) {
                    dfs(m, n, i, j, k, visited);
                }
            }
        }
        return count;
    }

    // dfs
    public void dfs(int m, int n, int a, int b, int k, boolean[][] visited) {
        if (a >= m || b >= n || !check(a, b, k) || visited[a][b]) return;
        count++;
        visited[a][b] = true;
        int[][] directions = {{0, 1}, {1, 0}};
        for (int i = 0; i < directions.length; i++) {
            dfs(m, n, a + directions[i][0], b + directions[i][1], k, visited);
        }
    }

    // check the inordinate is valid
    public boolean check(int m, int n, int k) {
        int sum = 0;
        while (m != 0) {
            sum += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum <= k;
    }
}
