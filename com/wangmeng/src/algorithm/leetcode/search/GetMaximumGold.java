package algorithm.leetcode.search;

/**
 * @ClassName GetMaximumGold
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/4
 */
public class GetMaximumGold {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(new GetMaximumGold().getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) flag[i][j] = true;
            }
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    sum = Math.max(sum, dfs(flag, grid, i, j));
                }
            }
        }
        return sum;
    }

    public int dfs(boolean[][] flag, int[][] grid, int x, int y) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        for (int i = 0; i < directions.length; i++) {
            int firstOffset = directions[i][0];
            int secondOffest = directions[i][1];
            // calculate the new position
            int newX = x + firstOffset;
            int newY = y + secondOffest;
            if (newX < 0 || newX > grid.length - 1 || newY < 0 || newY > grid[0].length - 1) continue;
            if (flag[newX][newY]) continue;
            // backtrace
            flag[x][y] = true;
            int currSum = grid[x][y] + dfs(flag, grid, newX, newY);
            if (currSum > ans) ans = currSum;
            flag[x][y] = false;
        }
        return ans == 0 ? grid[x][y] : ans;
    }
}
