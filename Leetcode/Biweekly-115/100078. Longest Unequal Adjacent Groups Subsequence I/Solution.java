import java.util.*;
import java.io.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        
        List<String> res = new ArrayList<String>();
        // sliding window?
        //int length = 1;
        int maxLen = 1;
        int maxStart = 0;
        int start = 0;
        //int end = 0;

        for (int i = 1; i < n; i++) {
            String curr = words[i];
            int currG = groups[i];

            if (currG == groups[i-1]) {
                int newMax = i-start;
                if (newMax > maxLen) {
                    maxLen = newMax;
                    maxStart = start;
                }
                start = i;
            }
        }
        
        if (n - start > maxLen) {
            maxLen = n - start;
            maxStart = start;
        }
        
        for (int i = maxStart; i < maxStart+maxLen; i++) {
            res.add(words[i]);
        }

        return res;
    }
}