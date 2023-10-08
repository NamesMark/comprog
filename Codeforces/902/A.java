import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum+= sc.nextInt();
            }
            System.out.println((sum*-1));
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