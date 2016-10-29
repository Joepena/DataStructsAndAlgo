#include <iostream>

struct node {
  int data;
  node *next;
  //constructor
  node(int d)
  {
    data = d;
    next =0;
  }
};

void listConstructor(int listSize, int *listData, node *&head) {
  node *runner;
  node *tHead =head;
  //first list created
  //std::cout << "constructing list..start"<<std::endl;
  for (int i = 0; i < listSize; i++) {
    if(tHead == 0){
      tHead = new node(listData[i]);
    //  std::cout << "head.."<<listData[i]<<std::endl;
      runner = tHead;
      continue;
    }
    runner->next = new node(listData[i]);
  //  std::cout << "next.."<<listData[i]<<std::endl;
    runner = runner->next;
  }
  head = tHead;
  //std::cout << "constructing list.. end"<<std::endl;
}

void interleaveLists(node *&mainList, node *&aux, int steps) {
  
  node *runnerM =  mainList;
  node *prevM = 0;
  node *runnerA =  aux;
  // mod the count, if it == steps add the next one
  int count =0;
  int modPos = steps+1;
  //std::cout << "interleave..."<<std::endl;
  while(runnerM && runnerA ){
    if(count%modPos == steps){
      prevM->next = runnerA;
      runnerA = runnerA->next;
      prevM->next->next = runnerM;
      count++;
      continue;
    }
    prevM = runnerM;
    runnerM = runnerM->next;
    count++;
  }
  //std::cout << "interleave... finished"<<std::endl;
}

void printList(node *head) {
  //std::cout << "print..."<<std::endl;
  while(head != NULL) {
    std::cout << head->data << " ";
    head = head->next;
  }
  std::cout<<std::flush;
  //std::cout << "print...finished"<<std::endl;
}

int main() {
  //input
//  std::cout << "Input began..."<<std::endl;
  int initSize;
  std::cin >> initSize;
  node *initList=0;
  int listData [initSize];
  //std::cout << "Input began for initList..."<<std::endl;
  for (int i = 0; i < initSize; i++) {
    std::cin >> listData[i];
  //  std::cout << "mirror..."<<i<<".. "<<listData[i]<<std::endl;
  }
  //construct first list
  listConstructor(initSize,listData,initList);
  //additional list
  int additionalLists;
  //std::cout << "additional list input"<<std::endl;
  std::cin>> additionalLists;
  if(additionalLists<=0) printList(initList);
  else{
    int stepStorage[additionalLists];
    node *heads [additionalLists];
    for(int i = 0; i< additionalLists;i++){
      //init to 0
      heads[i] = 0;
      int temp;
    //  std::cout << "additional list steps input"<<std::endl;
      std::cin>> temp;
      //store steps for corresponding list
      stepStorage[i] = temp;
      int tempSize;
    //  std::cout << "additional list size input"<<std::endl;
      std::cin>> tempSize;
      //list data
      int tempData[tempSize];
    //  std::cout << "Input began for tempList..."<<std::endl;
      for(int j = 0; j< tempSize;j++){
        std::cin>>tempData[j];
      //  std::cout << "mirror..."<<j<<".. "<<listData[j]<<std::endl;
      }
      //add list to the corresponding index
      listConstructor(tempSize,tempData,heads[i]);
    }
    //interleave the lists
    for(int i = 0; i <additionalLists;i++){
        interleaveLists(initList,heads[i],stepStorage[i]);
    }
    //print result
    printList(initList);
  }
  return 0;
}
