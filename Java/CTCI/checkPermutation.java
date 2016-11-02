import java.util.Arrays;

/**
 * Created by joe on 11/1/16.
 */
public class checkPermutation {
    public static void main(String[] args) {
       //positive testCase
        System.out.println(isPermutation("racecar","rcaerac"));
        System.out.println(isPermutation("beta","atbe"));
        //negative testCase
        System.out.println(isPermutation("xavier","reiaxs"));
        System.out.println(isPermutation("xavier","reis"));


    }
    public static boolean isPermutation(String s1, String s2){
        //first we should check if they are the same length. if not, they cannot be permutations of each other
        //we could sort both then check but that would be O(nlogn) for sort, O(n) for the check. making it O(nlogn+n) or O(nlogn)
        //we could make it faster by using some extra memory, lets use 2 arrays representing ascii values, we increment the values corresponding to each char
        //we then compare both arrays. So Space complexity: O(1) for we need 2 arrays but these arrays will always be int arrays of size 128.
        // Time complexity: O(n) (populate both arrays) + O(n) (checking both ascii arrays) = O(2n) or O(n) faster than first suggestion.

        if(s1.length()!=s2.length()) return  false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] asciiS1 = new int[128];
        int[] asciiS2 = new int[128];
        //populate both arrays
        for (int i=0; i <s1Arr.length;i++){
            asciiS1[(int)s1Arr[i]]++;
            asciiS2[(int)s2Arr[i]]++;
        }
        //check equality
        if(!Arrays.equals(asciiS1,asciiS2)) return false;
        return true;

    }
    /*After thought: I could have used one array and populate the array using the char counts of s1 and iterate my ascii array with s2 subtracting at each corresponding index and check for negatives to indicate inequal char counts*/
}
