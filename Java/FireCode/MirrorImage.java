/*
Write a method to check if the two given binary trees are the mirror images of each other.
Return true if they are, false otherwise. What's a binary tree's mirror image? Hold it by the root and rotate all other nodes by 180 degrees! 
*/

// we want to DFS and traverse for trees matching their left to right and right to left..

public boolean isMirror(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) return true;
    if((root1 == null && root2 != null)||(root2 == null && root1 != null)) return false;
    if(root1 !=null && root2 != null){
        if(root1.data != root2.data) return false;

        return isMirror(root1.right,root2.left) && isMirror(root2.right, root1.left);
    }
    return true;
}
