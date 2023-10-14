import java.util.*;
import java.io.*;

class Solution {
    class Solution {
        public List<Integer> lastVisitedIntegers(List<String> words) {
            List<String> numbers = new ArrayList<String>();
            
            int p = numbers.size()-1;
    
            List<Integer> res = new ArrayList<>();
            
            for (String word: words) {
                try {
                    if (Integer.parseInt(word) != -1) {
                        numbers.add(word);
                        p = numbers.size()-1;
                    }
                } catch (NumberFormatException e) {
    
                }
                if (word.equals("prev")) {
                    if (p >= 0) {
                        res.add(Integer.parseInt(numbers.get(p)));
                        p--;
                    } else {
                        res.add(-1);
                    }
                }
            }
    
            return res;
    
        }
    }
}