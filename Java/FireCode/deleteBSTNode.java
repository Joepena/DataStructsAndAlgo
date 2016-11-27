/*
Write a method to delete a node from a given
binary search tree.

We have 3 situations: We need to delete a leaf,a parent with 2 children, or a parent with one child.
if we have to delete a parent with 2 children we want to turn it into a situation where we can delete a leaf or a signle child parent.
So we find the smallest element in the right sub tree, replace it as the parents value and call delete on the value
*/

public TreeNode delete(TreeNode root, int data) { 
    //edge case
    if(root == null) return root;
    //search for node in BST
    if(root.data > data) root.left = delete(root.left,data);
    else if(root.data < data) root. right = delete(root.right,data);
    else{
        //leaf Node
        if(root.left == null && root.right == null) return null;
        //2 childern
        else if(root.left != null && root.right != null) {
            root.data = smallestRight(root.right);
            root.right = delete(root.right,root.data);
        }
        else{
            //one child
            if(root.left != null) return root.left;
            else return root.right;
        }
        
    }
    return root;

    
}
private int smallestRight(TreeNode root){
    if(root.left == null) return root.data;
    return smallestRight(root.left);
}