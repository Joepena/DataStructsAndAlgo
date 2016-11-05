/*
String permutations are the various possible strings made by the rearrangement of the characters in the original String.

For example, the permutations of car are:

car, cra, acr, arc, rac, rca

Write a recursive method getPermutations() that returns all permutations of an input String in an ArrayList.
Define a helper method if needed. For the sake of simplicity, assume that all characters in the input String are unique.
*/
public static ArrayList<String> getPermutations(String s) {
    if(s==null) return null;
    // find permutations starting with each letter, which is a subproblem in itself
    ArrayList<String> ans = new ArrayList<>();
    //a list of all Characters
    char[] strArr = s.toCharArray();
    ArrayList<Character> set = new ArrayList<>();
    for(char c: strArr) set.add(c);

     permutationHelper(ans,set,"");


    return ans;
}

public static void permutationHelper(ArrayList<String> ans, ArrayList<Character> set, String temp){
    //out of letter add to set
    if(set.isEmpty()) {
        ans.add(temp);
        return;
    }

    for(int i = 0; i < set.size(); i++){
        char cur = set.get(i);
        ArrayList tempSet = new ArrayList(set);
        tempSet.remove(i);
        permutationHelper(ans,tempSet,temp+cur);
    }
}
