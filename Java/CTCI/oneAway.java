public class OneAway {
    public static void main(String args[]){
        //test cases
        System.out.println(editChecker("pale","ple"));
        System.out.println(editChecker("pales","pale"));
        System.out.println(editChecker("pale","bale"));
        System.out.println(editChecker("pale","bake"));
    }
    /*There are 3 types of edits that can be performed on strings: insert, remove, and replace. Given 2 strings check if they are one edit away*/
    public static boolean editChecker(String s1, String s2){
        //define the operations: if s1.len == s2.len then we need to check for replacements
        //                       else it could be an insert or a removal
        if(s1.length() == s2.length()) return replaceOnlyOne(s1,s2);
        else if (s1.length()+1 == s2.length()) return insertOnlyOne(s2,s1);
        else if(s1.length() == s2.length()+1) return insertOnlyOne(s1,s2);
        else return false;

    }

    public static boolean replaceOnlyOne(String s1, String s2){
        char[] sArr1 = s1.toCharArray();
        char[] sArr2 = s2.toCharArray();
        int count = 0;
        for(int i = 0; i < s1.length(); i ++){
            if(sArr1[i]!= sArr2[i]) count++;
            if (count >1) return false;
        }
        return true;
    }

    public static boolean insertOnlyOne(String s1, String s2){
        //s1 is passed in as the bigger of the two
        char[] sArr1 = s1.toCharArray();
        char[] sArr2 = s2.toCharArray();
        int count = 0;
        for(int i = 0, j =0; i < s2.length(); i ++,j++){
            if(sArr1[i]!= sArr2[j]){
                count++;
                j--;
            }
            if (count >1) return false;
        }
        return true;
    }
}
