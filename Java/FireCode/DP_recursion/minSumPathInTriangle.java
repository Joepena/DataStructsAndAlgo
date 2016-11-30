/*
Given a 'triangle' as an ArrayList of ArrayLists of integers, with each list representing a level of the triangle, 
find the minimum sum achieved by following a top-down path and adding the integer at each level along the path. 
Movement is restricted to adjacent numbers from the top to the bottom.

Input Triangle: 
[   [1],
   [2, 3],
  [4, 5, 6],
[7, 8, 9, 10],
]

Output : 14 (1->2->4->7)
Note: [..] denotes an ArrayList
*/

//every number can vist the current index and +1 of the next array.
//the base case would be when we reach the bottom
public static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
    if(input == null || input.size() == 0) return 0;
    return minTriangleDepthHelper(input,0,0,0);
}

private static int minTriangleDepthHelper(ArrayList<ArrayList<Integer>> input,int row,int index,int curSum){
    if(row == input.size()) return curSum;
    
    return Math.min(minTriangleDepthHelper(input,row+1,index,input.get(row).get(index)+curSum),
                    minTriangleDepthHelper(input,row+1,index+1,input.get(row).get(index)+curSum));
}