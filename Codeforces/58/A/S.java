import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        String word = sc.nextLine().toLowerCase();
        String proper = "hello";
        int p = 0;
        for (char c: word.toCharArray()) {
            if (c == proper.charAt(p)) {
                p++;
            }
            if (p == 5) {
                break;
            }
        }
        
        boolean res = p == 5;

        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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