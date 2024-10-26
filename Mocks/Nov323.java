import java.util.*;
import java.io.*;

public class Nov323 {
    // Input: int[] nums 
    // sorted, unique
    // rotate 
    // [4,5,6,7,0,1,2]

    // Constraints:
    // 1 <= nums.length <= 10000
    // -10000 <= nums[i] <= 10000

    // Output: 
    // smallest value index

    public static void main(String[] args) {
        //int[] input = {4,5,6,7,0,1,2};
        int[] input = {0,1,2,3,4};

        // l = 0, r = 6, mid = 3, e = 7 > nums[n-1] => l = mid + 1;
        // l = 4, r = 6, mid = 5, e = 1 < nums[n-1] = > r = mid - 1;
        // l = 4, r = 4, mid = 4, e = 0
        // break;
        // return l = 4

        // {0,1,2,3,4}
        // l = 0, r = 4, mid = 2, e = 2 < nums[n-1] =>~ r = mid - 1
  
        int result = solve(input);

        System.out.println("Result: "+result);
        
    }

    private static int solve(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = n-1;

        while (l <= r) {
            int mid = l + (r-l)/2;

            if (nums[mid] < nums[n-1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

}