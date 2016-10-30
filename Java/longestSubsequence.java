static int longestSubsequence(String x, String y) {
    //DP
    char[] xCA = x.toCharArray();
    char[] yCA = y.toCharArray();
    int[][] grid = new int[yCA.length+1][xCA.length+1];

    for(int i=0;i<=yCA.length;i++){

        for(int j=0;j<=xCA.length;j++){

            if(i==0||j==0)
                grid[i][j] = 0;

            else if (yCA[i-1] == xCA[j-1])
                grid[i][j] = grid[i-1][j-1]+1;

            else
                grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]);
        }
    }
    return grid[yCA.length][xCA.length];

}
