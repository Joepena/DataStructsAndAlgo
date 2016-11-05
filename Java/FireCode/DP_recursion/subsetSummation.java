/*
Given an array of integers and a target number, determine if it is possible to choose a group of integers from the array,
 such that the numbers in the group sum to the given target.

Examples:
groupSum({1,2,3,6,5},10) ==> true
groupSum({1,2,3,6,5},18) ==> false
*/

public static boolean groupSum(int[] arr, int target) {
    ArrayList <Integer> list = new ArrayList<Integer>();
    for(int n: arr) list.add(n);
    return ( groupSumHelper(list,target,0));
}

public static boolean groupSumHelper(ArrayList <Integer> list, int target,int current){
    if(target == current) return true;
    if(current > target) return false;
    boolean ans = false;
    //add n+returned value
    for(int i=0; i < list.size(); i++){
        ArrayList<Integer> temp = new ArrayList<>(list);
        int n = temp.get(i);
        temp.remove(i);
        if(groupSumHelper(temp,target,current+n)) return true;
    }
    return false;
}
