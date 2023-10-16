import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    
    public static void main(String[] args) throws java.lang.Exception {
        
        int len = sc.nextInt();
        int[] seq = new int[len];

        
        for (int i = 0; i < len; i++) {
            seq[i] = sc.nextInt();
        }
        
        int currMountStep = 0;
        int p1 = 0;
        int p2 = len-1;
        while (p1 <= p2) {
            if (seq[p1] == currMountStep+1) {
                while (seq[p1] != seq[p2]) {
                    p2--;
                }
            }
            if (seq[p1] == seq[p2]) {
                p1++;
                p2++;
            }
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