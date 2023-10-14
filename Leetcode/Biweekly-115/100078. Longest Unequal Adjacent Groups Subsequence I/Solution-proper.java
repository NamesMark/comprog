import java.util.*;
import java.io.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        
        List<String> res = new ArrayList<String>();
        int prevG = groups[0];
        res.add(words[0]);
        
        for (int i = 1; i < n; i++) {
            if (groups[i] != prevG) {
                res.add(words[i]);
            }
            prevG = groups[i];
        }

        return res;
    }
}