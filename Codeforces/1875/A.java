import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int cases = sc.nextInt();

        while (--cases >= 0) {
            long a = sc.nextLong();
            long start = sc.nextLong();
            int toolsNum = sc.nextInt();

            long[] tools = new long[toolsNum];

            for (int i = 0; i < toolsNum; i++) {
                tools[i] = sc.nextLong();
            }
            long res = start;

            for (int i = 0; i < toolsNum; i++) {
                res += Math.min(tools[i], a-1);
            }

            System.out.println(res);
        
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