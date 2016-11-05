/*
Given an m x n matrix filled with non-negative integers, use dynamic programming techniques to find the maximum sum along a path from the top-left of the grid to the bottom-right.
Return this maximum sum. The direction of movement is limited to right and down.
*/
public static int matrixMaxSumDP(int[][] grid) {
    int m = grid.length+1;
    int n = grid[0].length+1;
    int [][] matrix = new int[m][n];

    for(int row = 0; row < m; row++){
        for(int col = 0; col < n; col++){
            if(row == 0 || col == 0) matrix[row][col] = 0;
            else{
                //we look left and up instead of right and down because we want to build the best sum
                //we would have at that specific position by looking at previous best sums.
                matrix[row][col] = grid[row-1][col-1]+Math.max(matrix[row-1][col],matrix[row][col-1]);
            }
        }
    }
    //the best sum would be at this point because it was constructed off of smaller steps
    return matrix[m-1][n-1];
}
