#include <iostream>

#include <queue>

using namespace std;

struct treeNode {
  int data;
  treeNode *left;
  treeNode *right;
  //constructor
  treeNode(int d)
  {
    data = d;
  }
};
int search(int values[], int begin, int end,int val){
    int i;
    for (i = begin; i <= end; i++)
    {
        if (values[i] == val)
            break;
    }
    return i;
}

treeNode * constructTree(int postOrder[], int inOrder[], int *index, int inOrderIndex, int inOrderEndIndex){

    if (inOrderIndex > inOrderEndIndex)
        return NULL;

    treeNode *n = new treeNode(postOrder[*index]);
    (*index)--;


    if (inOrderIndex== inOrderEndIndex)
        return n;

    int newIndex = search(inOrder, inOrderIndex, inOrderEndIndex, n->data);

    n->right= constructTree( postOrder, inOrder,index,newIndex+1, inOrderEndIndex);
    n->left = constructTree( postOrder, inOrder,index,inOrderIndex, newIndex-1);

    return n;
}

void levelOrder(treeNode *node){
    queue<treeNode*> q;
    q.push(node);
    while(q.size() > 0){
        treeNode *n = q.front();
        q.pop();
        if(n->left != NULL){
            q.push(n->left);
        }
        if(n->right != NULL){
            q.push(n->right);
        }
        cout<<n->data<<" ";
    }

}

int main() {
    int size;
    cin >>size;
    int postOrder[size];
    int inOrder[size];
    for(int i=0;i<size; i++){
        cin >>postOrder[i];
    }
    for(int i=0;i< size; i++){
       cin >> inOrder[i];

    }
    int index =sizeof(inOrder)/ sizeof(inOrder[0]);
    int num = index-1;
    treeNode *root = constructTree(postOrder,inOrder,&num,0,num);
    levelOrder(root);

}
