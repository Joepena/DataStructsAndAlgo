/*
Given the root node of a Binary Tree, write a method - validateBSTItr to iteratively
determine if it is a Binary Search Tree.

*/
public static boolean validateBSTItr(TreeNode root) {
    if(root == null) return false;
    int minMax = root.data;
    Queue<TreeNode> q = new LinkedList<>();

    // left side
    if(root.left != null){
        if(root.left.data > root.data) return false;
        q.add(root.left);

        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.data > minMax) return false;
            if(n.left != null){
                if(n.left.data > n.data )return false;
                else q.add(n.left);
            }
            //the right children of the root's left sub tree cannot have children bigger than root (minMax)
            if(n.right != null){
                if(n.right.data < n.data)return false;
                else q.add(n.right);
            }
        }
    }
    //right side
    if(root.right != null){
        if(root.right.data < root.data) return false;
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.data < minMax) return false;
            // the left child of the roots right subtree cannot be smaller than the root.
            if(n.left != null){
                if(n.left.data > n.data )return false;
                else q.add(n.left);
            }
            if(n.right != null){
                if(n.right.data < n.data )return false;
                else q.add(n.right);
            }
        }
    }
    return true;
}
/*
 After-thoughts: I could have made my own node structure where I mark the left or right child of therootand then
 ask if it is a child is from the left subtree or right subtree and proceed to make sure left tree stays less than root
 and right stays greater than root.
*/
