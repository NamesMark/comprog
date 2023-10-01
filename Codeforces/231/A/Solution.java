import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    // public static void solve(int n) {

        
    // }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        int sum = 0;
        while (testCases-- > 0) {
            int inputLength = 3;
            int currentProblemSure = 0;
            for (int i = 0; i < inputLength; i++) {
                currentProblemSure += sc.nextLong();
            }

            sum += currentProblemSure >= 2 ? 1 : 0;
        }
        System.out.println(sum);
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