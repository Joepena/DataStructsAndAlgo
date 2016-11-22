/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example: 
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4].

Your algorithm should run in O(n) complexity.
*/

public class longestConsecutive {
    public static void main(String[] args){
        int[] list1 = {100,4,101,99,1,3,2,200};
        ArrayList<Integer> case1 = new ArrayList<>();
        for(int i : list1) case1.add(i);
        ArrayList<Integer> ans =longestConsecutiveElementSequence(case1);
        for(int n: ans)System.out.print(n+" ");
    }
    public static ArrayList<Integer> longestConsecutiveElementSequence(ArrayList<Integer> list){
        ArrayList<Integer> ans = new ArrayList<>();
        if(list == null|| list.size() == 0) return ans;
        //set for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        //populate the set O(n) pass
        for(Integer n : list) set.add(n);
        //second pass into the set look for elements +1 or -1 to the current and populate a deque of them until done.
        Deque<Integer> deque = new LinkedList<>();
        for(Integer n : list){
            if(!set.contains(n)) continue;
            //add initial
            deque.addLast(n);
            //contains +1 to the element
            if (set.contains(n+1)){
                deque.addLast(n+1);
                int i = 2;
                while(set.contains(n+i)){
                    deque.addLast(n+i);
                    i++;
                }
            }
            if (set.contains(n-1)){
                deque.addFirst(n-1);
                int i = 2;
                while(set.contains(n-i)){
                    deque.addFirst(n-i);
                    i++;
                }
            }
            //we found all the elements for this integer.
            //deque is bigger than ans? update the arraylist
            if (deque.size()>ans.size()){
                ans.clear();
                ans.addAll(deque);

            }
            //also remove all thoes elements from set so we do not double iterate
            for(Integer integer: deque) {
                set.remove(integer);
            }
            //clear the deque
            deque.clear();
        }
        return ans;
    }
}
