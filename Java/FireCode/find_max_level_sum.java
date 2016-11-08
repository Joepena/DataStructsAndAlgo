/*
Given a binary tree,
write a method to return the level that has the maximum sum. In case the tree is empty, return -1
*/
//simple BFS with a max sum per level
public int findMaxSumLevel(TreeNode root) {
    //edge case
    if(root == null) return -1;
    int maxSum = 0;
    int curSum = 0;
    int curLevel = 0;
    int maxLevel = 0;
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.add(root);
    while(!q1.isEmpty()){
        TreeNode n = q1.poll();
        curSum+=n.data;
        if(n.left != null)q2.add(n.left);
        if(n.right != null)q2.add(n.right);

        if(q1.isEmpty()){
            if(curSum>maxSum){
                maxLevel = curLevel;
                maxSum = curSum;
            }
            curSum = 0;
            curLevel++;
            q1 = q2;
            q2 = new LinkedList<>();
        }
    }
    return maxLevel;
}
