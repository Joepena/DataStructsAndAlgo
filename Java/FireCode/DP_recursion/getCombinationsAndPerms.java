/*
Given a string, list all possible combinations and permutations of its characters.

Examples:
getCombPerms("a") ==> {"a"}
getCombPerms("ab") ==> {"a","ab","ba","b"}
*/
public static ArrayList<String> getCombPerms(String s) {
    //Approach: generate all permutations as we construct permutations we add them as combinations
    if(s == null) return null;
    //set of possible options
    ArrayList<Character> set = new ArrayList<>();
    for(char c : s.toCharArray()) set.add(c);
    ArrayList<String> ans  = new ArrayList<>();
    getPerms(set,ans,"");
    return ans;
}

private static void getPerms(ArrayList<Character> set, ArrayList<String> ans, String s){
//set empty = permutation constructed
    if(set.isEmpty()) {
        ans.add(s);
        return;
    }

    for(int i =0; i < set.size(); i++){
        // set that will have all the values next call can use
        ArrayList<Character> temp = new ArrayList<>(set);
        char c = temp.get(i);
        temp.remove(i);
        //to avoid duplicates we have to ask if this call to the function will be added. if not its a combo
        if(!temp.isEmpty()) ans.add(s+c);
        getPerms(temp,ans,s+c);
    }

}
