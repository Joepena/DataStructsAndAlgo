/*
Given the root of a Binary Tree  and an integer that represents the data value of a TreeNode present in the tree,
 write a method - pathLengthFromRoot that returns the distance between the root and that node.
 You can assume that the given key exists in the tree.
The distance is defined as the minimum number of nodes that must be traversed to reach the target node.
*/
public int pathLengthFromRoot(TreeNode root, int n1) {
    //if we do not find the node we will return null
    if(root == null) return 0;
    //is it in either left or right subtree? this implementation avoids extra searching by first searching left tree so if
    //we find it we stop and do not look at the right tree. Avoiding unnecessary work. if both are 0 return 0;
    else{
        int output = 0;
        if(root.data == n1 ||(output = pathLengthFromRoot(root.left,n1)>1)||(output = pathLengthFromRoot(root.left,n1)>1)){
            return output+1;
        }
    }
    return 0;



}
