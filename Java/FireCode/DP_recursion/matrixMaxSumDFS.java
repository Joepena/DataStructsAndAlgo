/*
Given an m x n matrix filled with non-negative integers,
use depth first search to find the maximum sum along a path from the top-left of the grid to the bottom-right.
Return this maximum sum. The direction of movement is limited to right and down.
*/

//limited to right and down movements (row +1) & (col+1) 2 choices per position.
//max of all the decision.
//when we hit a bound return -1
// else return the max of the two choices + current
//if we hit (m,n) return the sum with that element.

public static int matrixMaxSumDfs(int[][] grid) {
    return sumHelper(grid,0,0);
}

public static int sumHelper(int [][] grid, int row, int col){
    //out of bounds
    if( row > grid.length-1 || col > grid[0].length-1){
        return 0;
    }
    //new sum with current val
    //the end of the path
    if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];

    else{
        return(grid[row][col]+Math.max(sumHelper(grid, row+1, col),sumHelper(grid, row, col+1)));
    }
}
