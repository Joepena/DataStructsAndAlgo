/* Alice is a teacher with a class of n children, each of whom has been assigned a numeric rating. The classroom is seated in a circular arrangement, with Alice at the top of the circle. She has a number of gold stars to give out based on each child's rating, but with the following conditions:

            Each child must receive at least one gold star.
            Any child with a higher rating than his or her immediate neighbor should get more stars than that neighbor.

       Assuming n >= 3, what is the minimum total number of stars Alice will need to give out? */

    public static int goldStars(int [] arr) {
        //each child gets one
        int sol = arr.length;
        for(int i = 0 ; i <arr.length; i ++){
            int cur = arr[i];
            if(i>1 && i!=arr.length-1){
                //look both ways
                if(arr[i+1] < cur|| arr[i-1]< cur) sol++;

            }
            else if(i ==0){
                //beginning
                if(arr[i+1]<cur) sol++;
            }
            else{
                //end can only look left
                if(arr[i-1]<cur) sol++;

            }
        }
        return sol;
    }

    /*Bonus 1

    In the above example, child #3 has the same rating as child #2 but gets fewer stars. To be equitable, the number of stars should be {1, 2, 2}, resulting in a total number of 5 stars overall.

    Modify the algorithm so that any child with fewer stars than an immediate neighbor with an equal rating gets at least as many stars as that neighbor.*/
    public static int goldStarsBonus(int [] arr){
        //each child gets one
        int sol = arr.length;
        //stars array
        int[] stars = new int[arr.length];
        for(int i =0;i< stars.length;i++){
            stars[i] = 1;
        }

        for(int i = 0 ; i <arr.length; i ++){
            int cur = arr[i];
            if(i>1 && i!=arr.length-1){
                //look both ways
                if(arr[i+1] < cur|| arr[i-1]< cur) {
                    sol++;
                    stars[i]++;
                }
                if(stars[i-1]>stars[i]){
                    sol+=stars[i-1]=stars[i];
                    stars[i] = stars[i-1];
                }
            }
            else if(i ==0){
                //beginning
                if(arr[i+1]<cur){
                    sol++;
                    stars[i]++;
                }
            }
            else{
                //end can only look left
                if(arr[i-1]<cur){
                    sol++;
                    stars[i]++;
                }
                if(stars[i-1]>stars[i]){
                    sol+=stars[i-1]=stars[i];
                    stars[i] = stars[i-1];
                }
            }
        }
        return sol;
    }
