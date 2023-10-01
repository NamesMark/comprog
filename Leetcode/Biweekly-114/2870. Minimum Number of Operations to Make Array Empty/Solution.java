class Solution {
    public int minOperations(int[] nums) {
        
        Arrays.sort(nums);
        
        int ops = 0;
        
        int end = nums.length-1;

        int p = 1;
        int curr = nums[0];
        int numCurr = 1;
        while (p<=end) {
            //System.out.println("Curr "+curr+", num: "+nums[p]+", seen so far: "+numCurr);
            if (nums[p] == curr) {
                numCurr++;
            } else {
                
                while (numCurr > 2) {
                    if (numCurr % 3 == 0) {
                        //System.out.println("Adding: "+(numCurr / 3));
                        ops += numCurr / 3;
                    } else if (numCurr % 3 == 1) {
                        //System.out.println("Adding: "+((numCurr - 4) / 3 + 2));
                        ops += (numCurr - 4) / 3 + 2; 
                    } else {
                        //System.out.println("Adding: "+((numCurr - 2) / 3 + 1));
                        ops += (numCurr - 2) / 3 + 1;
                    }
                    numCurr = 0;
                }

                if (numCurr == 2) {
                    ops++;
                } else if (numCurr == 1) {
                    return -1;  
                }
                curr = nums[p];
                numCurr = 1;
            }
            p++;
        }
        
        while (numCurr > 2) {
            if (numCurr % 3 == 0) {
                //System.out.println("Adding: "+(numCurr / 3));
                ops += numCurr / 3;
            } else if (numCurr % 3 == 1) {
                //System.out.println("Adding: "+((numCurr - 4) / 3 + 2));
                ops += (numCurr - 4) / 3 + 2; 
            } else {
                //System.out.println("Adding: "+((numCurr - 2) / 3 + 1));
                ops += (numCurr - 2) / 3 + 1;
            }
            numCurr = 0;
        }

        if (numCurr == 2) {
            ops++;
        } else if (numCurr == 1) {
            return -1;  
        }
        
        return ops;
        
    }
}