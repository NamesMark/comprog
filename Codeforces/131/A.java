import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        String s = sc.nextLine();

        if ( Character.isLowerCase(s.charAt(0)) && s.substring(1).equals(s.substring(1).toUpperCase()) ) {
            System.out.println(String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase());
        } else if (s.equals(s.toUpperCase()) ) {
            System.out.println(s.toLowerCase());
        } else {
            System.out.println(s);
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