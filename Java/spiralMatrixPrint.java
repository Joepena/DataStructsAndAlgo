public static void SpiralMatrix(int[][] matrix){
        int upper =0;
        int left =0;
        int right = matrix.length-1;
        int bottom = matrix.length-1;
        int cur = 0;
        while(upper<=bottom && left <= right){
            if(cur == 0){
                //top bar
                for(int i = left; i <= right;i++){
                    System.out.print(matrix[upper][i]+", ");
                }
                upper++;
            }
            else if(cur == 1){
                //right bar

                for(int i = upper;i<=bottom;i++ ) {
                    System.out.print(matrix[i][right] + ", ");
                }
                right--;
            }
            else if(cur == 2){
                //bot bar
                for(int i = right; i >=left; i --){
                    System.out.print(matrix[bottom][i] + ", ");
                }
                bottom--;
            }
            else if(cur == 3){
                //left bar
                for(int i = bottom;i>=upper;i--){
                    System.out.print(matrix[i][left] + ", ");
                }
                left++;
            }
            cur = (cur+1)%4;
        }
    }
