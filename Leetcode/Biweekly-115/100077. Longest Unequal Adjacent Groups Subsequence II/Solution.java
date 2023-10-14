import java.util.*;
import java.io.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> res = new ArrayList<String>();
        res.add(words[0]);
        
        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i-1] && 
                words[i].length() == words[i-1].length() && 
                hammingDist(words[i], words[2]) == 1) 
            {
                res.add(words[i]);
            }
        }

        return res;
    }

    private int hammingDist(String w1, String w2) {
        char[] w1c = w1.toCharArray();
        char[] w2c = w2.toCharArray();
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            diff += Math.abs(w1c[i]-w2c[i]);
        }

        return diff;
    }
}