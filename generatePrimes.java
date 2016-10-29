public static void SieveofPrimes(int n){
        int [] nums = new int[n-1];
        int num = 2;
        //populate
        for(int i = 0; i< nums.length; i++){
            nums[i] = num;
            num++;
        }
        for(int i = 0; i< nums.length;i++){
            if(nums[i]== 0) continue;
            int cur = nums[i];
            for(int j = i+1; j<nums.length;j++){
                if(nums[j]%cur == 0) nums[j] = 0;
            }
        }
        for(int i = 0; i< nums.length; i ++){
            if(nums[i]!=0)System.out.print(nums[i]+", ");
        }
    }
