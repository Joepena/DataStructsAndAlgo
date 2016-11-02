public class urlify {
    public static void main(String [] args){
        //Test cases
        String s1 = "Mr John Smith    ";
        int s1Int = 13;
        urlMaker(s1,s1Int);
    }
    /*Write a method to replace all spaces in a string with '%20'. You may assume the string has sufficient space at the end to hold the
    additional characters, and that you are given the "true" length of the string.

    Ex: "Mr John Smith    ",13
        "Mr%20John%20Smith"
    * */
    public static void urlMaker(String s,int trueLength){
        //start from the end of the char array
        char[] charArr = s.toCharArray();
        //calculate space
        int spaceCount = 0;
        for(int i=0;i<trueLength;i++) if(charArr[i] == ' ')spaceCount++;
        int numOfShifts = spaceCount*2;
        int index = numOfShifts+trueLength;
        //shift the number a shifts and decrament by 2
        for(int i =trueLength-1; i>=0;i-- ){
            if(charArr[i] == ' '){
                charArr[index-1] = '0';
                charArr[index-2]='2';
                charArr[index-3]='%';
                index-=3;

            }else {
                charArr[index-1] = charArr[i];
                index--;
            }
        }
        System.out.println(new String(charArr));

    }
}
