package com.gacrnd.gcs.leakcanarytest;

/**
 * @author Jack_Ou  created on 2020/10/30.
 */
public class Test {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }

    private static int dfs (int[][] grid,int r,int c){
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)){
            return 1;
        }
        if (grid[r][c] == 0){
            return 1;
        }
        if (grid[r][c] != 1){
            return 0;
        }

        grid[r][c] = 2;
        return dfs(grid,r - 1,c) + dfs(grid,r,c - 1) + dfs(grid,r +1, c) + dfs(grid,r,c +1);
    }
}
