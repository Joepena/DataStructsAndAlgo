/*
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class Solution {
    //after each complete board i will parse it into a string
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    //construct the nxn board
	    ArrayList<ArrayList<String>> boards = new ArrayList<>();
	    if(a <=0) return boards;
	    char[][] tempBoard = new char[a][a];
	    boardSolver(boards,tempBoard,a,0,0);
	    return boards;
	}
	
	private void boardSolver(ArrayList<ArrayList<String>> boards, char[][] tempBoard, int goalQueens, int curQueens, int curRow){
	    
	    //we solved it
	    if(goalQueens == curQueens){
	        ArrayList<String> board = new ArrayList<>();
	        //convert temp board to string arraylist
	        parseBoard(board,tempBoard);
	        boards.add(board);
	        return;
	    }
	    //we have gone past the number of possible rows
	    if(curRow == tempBoard.length) return;
	    
	    for(int i=0; i<tempBoard[0].length;i++){
	        //column not available continue
	        if(tempBoard[curRow][i] != '.'){
	       
	            //if it is we will mark out the row/col/diags available to its placement
	            char[][] tBoard = new char[tempBoard.length][tempBoard.length];
	            copy2DArray(tempBoard,tBoard);
	            markOut(tBoard,curRow,i);
	              
	            boardSolver(boards,tBoard,goalQueens,curQueens+1,curRow+1);
	        }
	    }
	}
	//parseBoard
	private void parseBoard(ArrayList<String> board,char[][] tempBoard){
	    StringBuilder sB = new StringBuilder();
	    for(int i=0; i < tempBoard.length; i++){
	       for(int j = 0; j< tempBoard.length; j++){
	           sB.append(tempBoard[i][j]);
	       } 
	       //add row and clear sB
	       String tempS = new String(sB.toString());
	       board.add(tempS);
	       sB.setLength(0);
	    }
	}
	//copy2DArray
	private void copy2DArray(char[][] tempBoard,char[][] tBoard){
	    for(int i =0; i<tempBoard.length; i++){
	        for(int j =0; j< tempBoard.length; j++){
	            tBoard[i][j] = tempBoard[i][j];
	        }
	    }
	}
	//markOut
	private void markOut(char[][] tBoard, int currentRow, int currentCol){
	    //row 
	    for(int i=0; i < tBoard.length; i++){
	        tBoard[currentRow][i] = '.';
	    }
	    //col 
	    for(int i=0; i < tBoard.length; i++){
	        tBoard[i][currentCol] = '.';
	    }
	    //all diags
	    int diag1 = currentRow - currentCol;
	    int diag2 = currentRow + currentCol;
	    for(int i=0; i < tBoard.length; i++){
	      for(int j = 0; j < tBoard.length; j++){
	          if(diag1 == i-j||diag2 == i+j) tBoard[i][j] = '.';
	      }
	    }
	    //place 'Q'
	    tBoard[currentRow][currentCol] = 'Q';
	}
}
