import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    // public static void solve(int n) {

        
    // }

    public static void main(String[] args) {
        int testCases = 1;

        while (testCases-- > 0) {
            double m = sc.nextDouble();
            double n = sc.nextDouble();
            double a = sc.nextDouble();

            long res = -1;

            long height = (long) Math.ceil(m/a);
            long width = (long) Math.ceil(n/a);

            res = height * width;

            System.out.println(Math.max(1, res));
        
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