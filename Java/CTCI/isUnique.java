public class isUnique {
    //implement and algorithm to determine if a string has all unique characters.


    public static void main(String[] args) {
        String [] strArr = {
                //positive test-cases
                "aba",
                "abcdefggh",
                "%a%b",
                //negative test-cases
                "abcd",
                "abcrtoi",
                "Jjoseph"
        };
        for(String s: strArr){
            System.out.println(uniqueChecker(s));
        }

    }

    public static boolean uniqueChecker(String s){
        //save time using the pigeon hole principle (optimization)
        if(s.length() > 128) return false;
        int[] ascii = new int[128];
        char[] str = s.toCharArray();
        for(char c: str){
            if(ascii[(int)c]>0) return false;
            else ascii[(int)c]++;
        }
        return true;
    }


}
