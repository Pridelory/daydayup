package algorithm.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName GridIllumination
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/7
 */
public class GridIllumination {

    public static void main(String[] args) {
        int[][] lamps = new int[][]{{0, 0}, {1, 0}};
        int[][] queries = new int[][]{{1, 1}, {1, 1}};
        int[] ans = new GridIllumination().gridIllumination_hashmap(5, lamps, queries);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    /**
     * hashmap方法
     * @param n
     * @param lamps
     * @param queries
     * @return
     */
    public int[] gridIllumination_hashmap(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> mainDiagonal = new HashMap<>();
        Map<Integer, Integer> antiDiagonal = new HashMap<>();
        Set<Long> points = new HashSet<>();

        // lighting process
        for (int[] lamp : lamps) {
            if (!points.add(hash(lamp[0], lamp[1]))) {
                continue;
            }
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            mainDiagonal.put(lamp[0] - lamp[1], mainDiagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            antiDiagonal.put(lamp[0] + lamp[1], antiDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryRow = queries[i][0];
            int queryCol = queries[i][1];
            if (row.getOrDefault(queryRow, 0) > 0) ans[i] = 1;
            if (col.getOrDefault(queryCol, 0) > 0) ans[i] = 1;
            if (mainDiagonal.getOrDefault(queryRow - queryCol, 0) > 0) ans[i] = 1;
            if (antiDiagonal.getOrDefault(queryRow + queryCol, 0) > 0) ans[i] = 1;

            // extinguishing
            for (int j = queryRow - 1; j <= queryRow + 1; j++) {
                for (int k = queryCol - 1; k <= queryCol + 1; k++) {
                    if (points.remove(hash(j, k))) {
                        if (j < 0 || j >= n || k < 0 || k >=n) continue;
                        row.put(j, row.get(j) - 1);
                        col.put(k, col.get(k) - 1);
                        mainDiagonal.put(j - k, mainDiagonal.get(j - k) - 1);
                        antiDiagonal.put(j + k, antiDiagonal.get(j + k) - 1);
                    }
                }
            }
        }
        return ans;
    }

    public long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }

    /**
     * simulation method
     * 超时
     * @param n
     * @param lamps
     * @param queries
     * @return
     */
    public int[] gridIllumination_simulation(int n, int[][] lamps, int[][] queries) {
        int index = 0;
        int[] ans = new int[queries.length];
        Map<Integer, Integer> hashMap = new HashMap<>();
        Bulb[][] grid = new Bulb[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Bulb();
            }
        }

        // open the light
        for (int i = 0; i < lamps.length; i++) {
            int lampX = lamps[i][0];
            int lampY = lamps[i][1];
            if (hashMap.containsKey(lampX) && hashMap.get(lampX) == lampY) continue;
            hashMap.put(lampX, lampY);
            // open the light of current position
            grid[lampX][lampY].type = 2;
            grid[lampX][lampY].count++;
            // open the light of the same row
            for (int j = 0; j < n; j++) {
                if (j == lampY) continue;
                grid[lampX][j].count++;
            }

            // open the light of the same col
            for (int j = 0; j < n; j++) {
                if (j == lampX) continue;
                grid[j][lampY].count++;
            }

            // open the light of the main diagonal
            for (int k = lampX - 1, l = lampY - 1; k >= 0 && l >= 0; k--, l--) {
                grid[k][l].count++;
            }
            for (int k = lampX - 1, l = lampY + 1; k >= 0 && l < n; k--, l++) {
                grid[k][l].count++;
            }
            // open the light of the sub diagonal
            for (int k = lampX + 1, l = lampY - 1; k < n && l >= 0; k++, l--) {
                grid[k][l].count++;
            }
            for (int k = lampX + 1, l = lampY + 1; k < n && l < n; k++, l++) {
                grid[k][l].count++;
            }
        }

        // query
        for (int i = 0; i < queries.length; i++) {
            int queryX = queries[i][0];
            int queryY = queries[i][1];
            ans[index++] = grid[queryX][queryY].count > 0 ? 1 : 0;
            // close the eight sides around the current position and the current position
            for (int j = -1; j < 2; j++) {
                for (int m = -1; m < 2; m++) {
                    int newPosX = queryX + j;
                    int newPosY = queryY + m;
                    if (newPosX < 0 || newPosX >= n || newPosY < 0 || newPosY >=n) continue;
                    if (grid[newPosX][newPosY].type == 2) {
                        grid[newPosX][newPosY].type = 0;
                        grid[newPosX][newPosY].count--;
                        // close the light of radiation of the current light generates
                        for (int x = 0; x < n; x++) {
                            if (x == newPosY) continue;
                            grid[newPosX][x].count--;
                        }

                        for (int x = 0; x < n; x++) {
                            if (x == newPosX) continue;
                            grid[x][newPosY].count--;
                        }

                        // open the light of the main diagonal
                        for (int k = newPosX - 1, l = newPosY - 1; k >= 0 && l >= 0; k--, l--) {
                            grid[k][l].count--;
                        }
                        for (int k = newPosX - 1, l = newPosY + 1; k >= 0 && l < n; k--, l++) {
                            grid[k][l].count--;
                        }
                        // open the light of the sub diagonal
                        for (int k = newPosX + 1, l = newPosY - 1; k < n && l >= 0; k++, l--) {
                            grid[k][l].count--;
                        }
                        for (int k = newPosX + 1, l = newPosY + 1; k < n && l < n; k++, l++) {
                            grid[k][l].count--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class Bulb {
    // 0 -- dark 1 -- influenced light 1 -- source light
    public int type;
    // count of illuminated
    public int count;
}
