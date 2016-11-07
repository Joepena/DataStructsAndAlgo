/*
Given a String input, find the length of the longest substring that is made up of non-repeating characters.
 For ex, the longest substrings without repeated characters in “BCEFGHBCFG” are “CEFGHB” and “EFGHBC”, with length = 6.
In the case of "FFFFF", the longest substring is "F" with a length of 1.

Example:
Input : aaabbbabcde
Output: 5
*/
//we want to run through the array using extra space to track first occurence of
//the elements and use that as we go. Every collison we update current to index-occurence of the element

public static int longestNRSubstringLen(String input) {
    //coner cases: null input and empty string
    if(input == null||input.length() ==0) return 0;
    //here is our extra space, we wish to store positions in this array but the array is initialized with 0's
    int[] asciiTable = new int[128];
    Arrays.fill(asciiTable,-1);
    char[] cArr = input.toCharArray();
    //mark the position of our first letter in the Array
    asciiTable[(int)cArr[0]] = 0;
    int maxLen = 1;
    int curLen = 1;

    for(int i=1;i<cArr.length;i++){
        //if not occuring in our subsequence, update and increase current
        if(asciiTable[(int)cArr[i]] == -1){
            asciiTable[(int)cArr[i]] = i;
            curLen++;
        }
        else{
            //already occured in our substring, update max and then update current
            maxLen = Math.max(maxLen,curLen);
            //edge case: if dealing with the first element the substraction would not change the
            // current length so we must account for it.
            curLen = i - asciiTable[(int)cArr[i]];
            //now update the last occurence in this new substring
            asciiTable[(int)cArr[i]] = i;
        }
    }
    //update maxLen incase final curLen is bigger
    maxLen = Math.max(maxLen,curLen);
    return maxLen;
}
