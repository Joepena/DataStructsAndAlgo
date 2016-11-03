/*You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a String - word.
 Write a method - boggleSearch that searches the Boggle Board for the presence of the input word.
  Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal).
Also, each letter on the Boggle Board must be used only once. */
public static class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public static boolean boggleSearch(char[][] board, String word){

    HashSet<Pair> setVisited = new HashSet<>();
    for(int i =0; i<board.length;i++){
        for(int j=0;j<board[0].length;j++){

            if(board[i][j]==word.charAt(0)){
                if(search(board,setVisited,"",i,j,word)) return true;
            }
        }
    }
    return false;

}
public static boolean search(char[][] board,  HashSet<Pair> setVisited,String cur,int r,int c,String word){
    Pair p = new Pair(r,c);
    //out of bounds or already visited
    if( r > board.length-1 ||  c > board[0].length-1 || r < 0 || c < 0 || !setVisited.add(p)) return false;
    char ch = board[r][c];
    String nWord = cur+ch;
    int key = nWord.length();
    //is it a valid prefix?
    if(!nWord.equals(word.substring(0,key))) return false;
    //is it the actual word?
    if(nWord.equals(word.substring(0))) return true;
    setVisited.add(p);
    if(
        search(board,setVisited,nWord,r+1,c,word)||
        search(board,setVisited,nWord,r-1,c,word)||
        search(board,setVisited,nWord,r,c+1,word)||
        search(board,setVisited,nWord,r,c-1,word)
        ){
            return true;
        }
        return false;

}
/*After thought: This solution works but I can definitely make it better, Next time I will not use the Pair class/ hash set to check already visited.
I will instead mark the board at each call and un mark it after the calls to that node are complete. Will save me memory and I will only be passing a
board,a current string, row index, col index, and the word I want.
*/
