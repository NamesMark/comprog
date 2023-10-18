import java.util.*;
import java.io.*;

public class October18 {
    // Input: int[] nums 
    // 1 <= nums.length <= 10^4
    // -10^4 <= nums[i] <= 10^4
    // 1 <= k <= 10^4
    // Output: 
    // int[] of length k
    // [1,1,1,2,2,3], k = 2
    // res [1,2]

    public static void main(String[] args) {
        int[] input = {9,9,9,5,5,3};
        int k = 2;

        int[] result = solve(input, k);

        System.out.println("Result: "+Arrays.toString(result));
        
    }

    private static int[] solve(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();                    // O(N) space

        for (int n: arr) {                                              // O(N) time
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();     // O(N) space

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {       // O(X) where X is unique values -> O(N)
            list.add(entry);
        }
        // if we use a priority queue here instead of sort list, would it be faster?
        // check: quick select?

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());  // O(NlogN) time
        
        int[] resArr = new int[k];                                      // O(K) space; k < N so disregard

        for (int i = 0; i < k; i++) {                                   // O(K) time; k < N so disregard
            resArr[i] = list.get(i).getKey();
        }

        return resArr;
    }

}