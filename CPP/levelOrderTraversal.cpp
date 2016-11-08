#include <iostream>
#include <unordered_map>
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

treeNode * constructTree(){

  unordered_map<int,treeNode*> map;
  treeNode *root = NULL;
  int lines;
  cin >> lines;

  for(int i = 0; i < lines; i++){
      int temp;
      cin >>temp;
      auto it = map.find(i);
      //if already made
      if(it != map.end()){
          map.at(i)->data = temp;
      }
      else map.emplace(i, new treeNode(temp));

      temp = 0;
      cin>>temp;
      //left
      if(temp != -1){
          it = map.find(temp);
          if(it != map.end()) map.at(i)->left = map.at(temp);
          else {
              map.at(i)->left = new treeNode(0);
              map.emplace(temp,map.at(i)->left);
          }
      }
      else map.at(i)->left = NULL;
      temp = 0;
      cin>>temp;
      //right
      if(temp != -1){
          it = map.find(temp);
          if(it != map.end()) map.at(i)->right = map.at(temp);
          else {
              map.at(i)->right = new treeNode(0);
              map.emplace(temp,map.at(i)->right);
          }
      }
      else map.at(i)->right = NULL;


  }
    return map.at(0);
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
    treeNode *root = constructTree();
    levelOrder(root);
}
