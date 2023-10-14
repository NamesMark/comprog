import java.util.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.Arrays;
import java.io.*;

public class October14 {

    // # Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // # Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    // eat, tea => aet aet 

    // Follow-up:
    // Optimization 1: 
    // Map<Map<String, List<String>>> map = new HashMap<>(); // length, 

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(List<String> element: result) {
            System.out.print(element.toString());
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {                  // O(N * KlogK)
            String sortS = lexSort(s);
            List<String> storedList = map.get(sortS);
            if (storedList == null) {
                storedList = new ArrayList<String>();
                storedList.add(s);
                map.put(sortS, storedList);    // O(1)
            } else {
                map.get(sortS).add(s);         // O(1)
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static String lexSort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);                 // O(KlogK)
        return new String(array);
    }
}