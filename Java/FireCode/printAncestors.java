/*Given a binary tree's root node, an empty ArrayList and an integer nodeData,
 write a method that finds a target node - N with data = nodeData and populates
 the ArrayList with the data of the ancestor nodes of N - added from the bottom - up.
*/
//Populate the list of ancestors from bottom to top in the below list.
public ArrayList<Integer> ancestorsList = new ArrayList<Integer>();

public boolean printAncestors(TreeNode root, int nodeData) {
    if(root == null) return false;
    //we found it return true
    if(root.data == nodeData) return true;
    //am I the root of a sub-tree containing the target?
    //add me to list and pass true up so my parent can know too
    if(printAncestors(root.left,nodeData)||printAncestors(root.right,nodeData)){
        ancestorsList.add(root.data);
        return true;
    }
    //found nothing return false so we dont add anybody on this sub-tree
    return false;
}
