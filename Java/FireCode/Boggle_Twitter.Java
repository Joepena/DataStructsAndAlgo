/*
You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a fast,
electronic Dictionary in the form of a Prefix Tree or Trie. Write a method - boggleSearchWithDict that searches the Boggle Board for words in the dictionary.
Your method should return an alphabetically sorted ArrayList of words that are present on the board as well as in the dictionary.
Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal).
Also, each letter on the Boggle Board must be used only once.
Your program should run in a reasonable amount of time (at max about 50 ms for each test case) and shouldn't time out.
*/
public ArrayList<String> boggleSearchWithDict(char[][] board, Trie dictionary){
    // recursive if prefix is found on the letter we will proceed else return
    TreeSet<String> set = new TreeSet<>();

    for(int i=0; i < board.length; i++){
        for(int j = 0; j <board.length;j++){
            boggleHelper("",board,dictionary,set,i,j);
        }
    }
    ArrayList<String> ans = new ArrayList<String>();
    while(!set.isEmpty()){
        ans.add(set.pollFirst());
    }
    return ans;

}

public void boggleHelper(String cur, char[][] board,Trie dictionary,TreeSet<String> set, int posx,int posy){
    //out of bounds call or already visited
    if(posx > board.length-1 || posx < 0 || posy < 0 || posy > board[0].length-1 ) return;
    //are we a word? add to list
    String word =cur+board[posx][posy];
    if(dictionary.searchWord(word)){
        set.add(word);
    }


    //if not are we a prefix? if we are lets search more
    if(dictionary.searchPrefix(word)){
        boggleHelper(word,board,dictionary,set,posx+1,posy);
        boggleHelper(word,board,dictionary,set,posx-1,posy);
        boggleHelper(word,board,dictionary,set,posx,posy+1);
        boggleHelper(word,board,dictionary,set,posx,posy-1);

    }

}
