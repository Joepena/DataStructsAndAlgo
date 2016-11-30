/*
You are given an n x n square 2D matrix that represents the pixels of an image.
Rotate it by 90 degrees in the clockwise direction.
*/
public static int[][] rotate(int[][] matrix) {
    if(matrix == null) return null;
    horizontalFlip(matrix);
    transpose(matrix);
    return matrix;
}

private static void horizontalFlip(int[][] matrix){
    for(int row = 0; row<matrix.length/2; row++){
        for(int col = 0; col<matrix[0].length; col++){
            int temp = matrix[matrix.length-1-row][col];
            matrix[matrix.length-1-row][col] = matrix[row][col];
            matrix[row][col] = temp;
        }
    }

}

private static void transpose(int[][] matrix){
    for(int row = 0; row<matrix.length; row++){
        for(int col = row+1; col<matrix.length; col++){
            int temp = matrix[col][row];
            matrix[col][row] = matrix[row][col];
            matrix[row][col] = temp;
        }
    }
}