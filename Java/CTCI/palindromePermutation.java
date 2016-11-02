public class palindromePermutation {
    public static void main(String[] args) {
        System.out.println(palindromePermChecker("tactcoapapa"));


    }
    //given a string, write a function to check if it is a permutation of a palindrome.
    //ex: "Tact Coa" -> True ("taco cat", "atco cta")
    public static boolean palindromePermChecker(String s1){
        int[] ascii = new int[128];
        char[] cArr = s1.toCharArray();
        for(char c : cArr) ascii[(int)c] ++;
        if(cArr.length%2 == 0){
            //even means 2 unpaired chars are allowed in a palindrome ex: "taco cat"-> 'o' and ' '
            int count = 0;
            for(int n : ascii){
                if(n==0) continue;
                if(n%2!=0) count++;
                if (count >2) return false;
            }
            return(count==2)?true:false;
        }else{
            //odd only one mismatching char
            int count = 0;
            for(int n : ascii){
                if(n==0) continue;
                if(n%2!=0) count++;
                if (count >1) return false;
            }
            return(count==1)?true:false;
        }

    }
}
