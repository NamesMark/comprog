import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int T = sc.nextInt();

        while (--T >= 0) {
            int n = sc.nextInt();
            String s = sc.nextLine();
            int res = -1;

            if (isGood(s)) { // s already good
                res = 0;
            } else {          

            }

            System.out.println(res);
        }
    }

    private static boolean isGood (String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) == s.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
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