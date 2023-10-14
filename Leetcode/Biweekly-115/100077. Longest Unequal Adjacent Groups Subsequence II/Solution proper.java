import java.util.*;
import java.io.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Iter i: "+i+", curWord: "+words[i]);
            List<String> currRes = new ArrayList<>();
            currRes.add(words[i]);
            int prevG = groups[i];
            String prev = words[i];
            
            for (int j = i + 1; j < n; j++) {
                System.out.println("Iter j: "+j+", curWord: "+words[j]);
                if (groups[j] != prevG && 
                    words[j].length() == prev.length() && 
                    hammingDist(words[j], prev) == 1) 
                {
                    currRes.add(words[j]);
                    prevG = groups[j]; 
                    prev = words[j];
                }
            }
            if (currRes.size() > res.size()) {
                res = new ArrayList<>(currRes);
            } else {
                currRes = new ArrayList<>();
                currRes.add(words[i]);
                prevG = groups[i];
                prev = words[i];
                for (int j = i + 2; j < n; j++) {
                    System.out.println("Iter j: "+j+", curWord: "+words[j]);
                    if (groups[j] != prevG && 
                        words[j].length() == prev.length() && 
                        hammingDist(words[j], prev) == 1) 
                    {
                        currRes.add(words[j]);
                        prevG = groups[j]; 
                        prev = words[j];
                    }
                }
                System.out.println("Curr res: "+currRes.toString());

                if (currRes.size() > res.size()) {
                    res = new ArrayList<>(currRes);
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

