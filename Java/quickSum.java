static int sum(int[] numbers) {
 int ans = 0;
 int lastocc = 0;
 for(int i =0, j = numbers.length-1;i<j;i++,j--){
     ans+=(numbers[i]+numbers[j]);
     lastocc = i;
 }
 if(numbers.length%2 == 0)return ans;
 else return ans+numbers[lastocc+1];
}
