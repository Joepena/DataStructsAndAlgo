/*
Given a String that represents the digits pressed on a classic cell phone keypad
 - return all possible letter combinations that the numbers could represent in an ArrayList of Strings.
Check out the keypad and mapping below for reference.

2 -> "abc"          Ex: Input  : "34"
3 -> "def"              Output : [dg, dh, di, eg, eh, ei, fg, fh, fi]
4 -> "ghi"
5 -> "jkl"
6 -> "mno"
7 -> "pqrs"
8 -> "tuv"
9 -> "wxyz"
*/
public static  ArrayList<String> getStringsFromNums(String digits) {
      //first we need some sort of mapping for each Number, how about we map an Integer to a ArrayList of Characters?
      HashMap<Integer,ArrayList<Character>> mapping = new HashMap<>();
      //lets populate it.
      //an array list of character arraylist to populate the map
      ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>(Arrays.asList(
          new ArrayList<>(Arrays.asList('a','b','c')),
          new ArrayList<>(Arrays.asList('d','e','f')),
          new ArrayList<>(Arrays.asList('g','h','i')),
          new ArrayList<>(Arrays.asList('j','k','l')),
          new ArrayList<>(Arrays.asList('m','n','o')),
          new ArrayList<>(Arrays.asList('p','q','r','s')),
          new ArrayList<>(Arrays.asList('t','u','v')),
          new ArrayList<>(Arrays.asList('w','x','y','z'))
          ));
      for(int i = 0; i < list.size(); i++){
          mapping.put(i+2,list.get(i));
      }
      //we need an arraylist to hold our output
      ArrayList<String> ans = new ArrayList<>();

      getStringsFromNumsHelper(mapping,digits,"",ans);

      return ans;
}

public static void getStringsFromNumsHelper(HashMap<Integer,ArrayList<Character>> mapping,String digits,
                                            String temp,ArrayList<String> ans){
    // we are out of numbers to work with so this is one of the leaves of our recursion
    if(digits == null || digits.length() == 0){
      ans.add(temp);
      return; //NEVER FORGET TO RETURN (After-thought)
    }
    //we want the value of the first digit
    int digit = Character.getNumericValue(digits.charAt(0));
    //remove it from digits
    digits = digits.substring(1);
    //generate all possible combinations of this digit
    ArrayList<Character> tempList = mapping.get(digit);
    for(int i = 0; i < tempList.size(); i++){
        char c = tempList.get(i);
        //we are appending a possible value of the current digit
        //to each call, imagine a decision tree and it branches out to all possible values it can take
        getStringsFromNumsHelper(mapping,digits,temp+c,ans);
    }

}
