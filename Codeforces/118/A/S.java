import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    // public static void solve(int n) {

        
    // }

    public static void main(String[] args) {
        String str = sc.nextLine().toLowerCase();

        StringBuilder sb = new StringBuilder();

        char[] vowels = {'a', 'o', 'y', 'e', 'u', 'i'};

        processor:for (char c: str.toCharArray()) {
            for (char v: vowels) {
                if (v == c) {
                    continue processor; 
                }
            }
            sb.append('.').append(c);
        }

        System.out.println(sb.toString());

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