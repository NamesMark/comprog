import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
    
        while (--t >= 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int maxLen = 0;
            int start = 0;
            int end = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int countDistinct = 0;

            //System.out.printf("Initial State: start=%d, end=%d, countDistinct=%d, maxLen=%d%n", start, end, countDistinct, maxLen);

        while (end < n) {
            int currNum = arr[end];
            map.put(currNum, map.getOrDefault(currNum, 0) + 1);
            if (map.get(currNum) == 1) {
                countDistinct++;
            }

            //System.out.printf("Iteration: end=%d, currNum=%d, countDistinct=%d, map=%s%n", end, currNum, countDistinct, map.toString());

            while (start <= end && map.getOrDefault(y, 0) > 0) {
                if (countDistinct == x) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
                //System.out.printf("Condition Met: start=%d, end=%d, maxLen=%d%n", start, end, maxLen);

                int abandNum = arr[start];
                map.put(abandNum, map.get(abandNum) - 1);
                if (map.get(abandNum) == 0) {
                    countDistinct--;
                }
                start++;

                //System.out.printf("Adjusting Start: start=%d, abandNum=%d, countDistinct=%d, map=%s%n", start, abandNum, countDistinct, map.toString());
            }
            end++;
        }
        //System.out.printf("Final Result: maxLen=%d%n", maxLen);
        System.out.println(maxLen);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}