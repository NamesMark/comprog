import java.util.*;
import java.io.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> res = new ArrayList<String>();
        if (words.length == 1) {
            res.add(words[0]);
            return res;
        }
        
        for (int i = 0; i < n; i++) {
            List<String> currRes = new ArrayList<>();
            currRes.add(words[i]);
            int prevG = groups[i];
            String prev = words[i];
            for (int j = i + 1; j < n; j++) {
                //System.out.println("Iter i: "+i+", curWord: "+words[i]);
                if (groups[j] != prevG &&
                    words[j].length() == prev.length() &&
                    hammingDist(words[j], prev) == 1) {
                        currRes.add(words[j]);
                        prevG = groups[j];
                        prev = words[j];
                }
                
                for (int k = j; k < n; k++) {
                    //System.out.println("Iter j: "+j+", curWord: "+words[j]);
                    if (groups[k] != prevG && 
                        words[k].length() == prev.length() && 
                        hammingDist(words[k], prev) == 1) {
                            currRes.add(words[k]);
                            prevG = groups[k]; 
                            prev = words[k];
                    }
                }
                if (currRes.size() > res.size()) {
                    res = new ArrayList<>(currRes);  
                    currRes = new ArrayList<>();  
                    currRes.add(words[i]); 
                    prevG = groups[i]; 
                    prev = words[i]; 
                }
            }
        }
        return res;
    }

    private int hammingDist(String w1, String w2) {
        char[] w1c = w1.toCharArray();
        char[] w2c = w2.toCharArray();
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1c[i] != w2c[i]) {
               diff++;
            }
        }
        return diff;
    }
}

