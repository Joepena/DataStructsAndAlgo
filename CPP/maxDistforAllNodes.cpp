/*
    For any two nodes in a tree, the distance between those two nodes is equal to the number of edges 
    you need to traverse to go from one node to the other, i.e. the number of edges in the path between the two nodes.
    Given a tree we want to find the Maximum Distance for all of the nodes in the tree in linear, i.e. O(n), time.
    Input:            Output:
        8                  3
        0 4                4
        1 5                4
        2 3                3 
        3 4                2
        4 5                3
        4 6                3 
        5 7                4
*/

#include <iostream>

#include <queue>
#include <unordered_map>


using namespace std;

struct TreeNode {
  vector<TreeNode*> adjacentNodes;
  int label;
  TreeNode(int l){
      label = l;
  }

};
vector<int> maxDistances;

int distHelper(TreeNode *startNode,  int size, bool mark){
    bool visitingSet[size];
    for(int i=0;i<size;i++) visitingSet[i] = false;

    int level = 0;
    queue<TreeNode*> queue1;
    queue<TreeNode*> queue2;
    //add first node
    queue1.push(startNode);
    visitingSet[startNode->label] = true;
    int furthest = 0;

    while(!queue1.empty()){
        level += 1;
        //iterate to all children and add to temp-queue
        while(!queue1.empty()){
            TreeNode * current = queue1.front();
            queue1.pop();
            furthest = current->label;
            for(int i = 0; i<current->adjacentNodes.size(); i++ ){
                int adjacentNode = current->adjacentNodes.at(i)->label;
                if(!visitingSet[adjacentNode]){
                    if(mark){
                        maxDistances[adjacentNode] = max(maxDistances[adjacentNode],level);
                    }
                    visitingSet[adjacentNode] = true;
                    queue2.push(current->adjacentNodes.at(i));
                }
            }
        }
        if(queue2.empty()) return furthest;
        swap(queue1,queue2);
    }
    return startNode->label;
}




int main() {
    //prime data
    unordered_map<int, TreeNode*> map;
    vector<pair<int,int>> edges;
    int pairs ;
    cin >> pairs;
    for(int i = 0; i < pairs-1; i++){
        // place pairs in vector and emplace it
        int x;
        int y;
        cin >> x;
        cin >> y;
        //cout << "pair: "<<x<<" and "<<y<<endl;
        //place in edges list
        edges.push_back(make_pair(x,y));

        //map it
        auto it = map.find(x);
        //if not hash map, make it
        if(it == map.end()){
            map.emplace(x,new TreeNode(x));
            //cout << "made node: "<<x<<endl;
        }
        //y
        it = map.find(y);
        if(it == map.end()){
            map.emplace(y,new TreeNode(y));
            //cout << "made node: "<<y<<endl;
        }

    }

    //construct graph by adding adjacent nodes to list
    for(int i=0; i < edges.size(); i++){
        pair<int,int> p = edges.at(i);
        int x = p.first;
        int y = p.second;
        //add y to x's adjacency vector
        map.at(x)->adjacentNodes.push_back(map.at(y));
        //add x to y's adjacency vector
        map.at(y)->adjacentNodes.push_back(map.at(x));

    }

    //create a vector of all nodes within the graph
    vector<TreeNode*> nodes;
    for ( int i=0; i <= pairs-1; i++ ) {
        nodes.push_back(map.at(i));

    }
    //fill the array
    for(int i = 0; i< pairs;i++) maxDistances.push_back(0);
    //Algorithm

    //find the furthest from arbitrary node
    int startOfDiameter = distHelper(map.at(0), nodes.size(), false);
    //find furthest from the start node
    int endOfDiameter = distHelper(map.at(startOfDiameter),nodes.size(),true);
    //final update
    distHelper(map.at(endOfDiameter),nodes.size(), true);
    //print the answer
    for(int i =0; i < maxDistances.size(); i++) cout<<maxDistances.at(i)<<endl;
}