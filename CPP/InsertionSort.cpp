#include <iostream>
int main() {
  std::ios_base::sync_with_stdio(false) ;

  int size;
  std::cin >> size;
  int nums [size];
  //populate array
  for (int i = 0; i < size; i++) {
    std::cin>>nums[i];
  }
  //sort array

  for (int i = 1; i <size; i++) {
    int j = i;
    while(j > 0 && nums[j-1] > nums[j]){
        int tmp = nums[j];
        nums[j] = nums[j-1];
        nums[j-1] = tmp;
        j--;
    }

  }
  //print
  for (int i = 0; i < size; i++) {
    std::cout << nums[i] << "\n";
  }
  return 0;
}
