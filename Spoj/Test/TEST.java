import java.util.*;
import java.io.*;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) throws java.lang.Exception {
        
        //int cases = sc.nextInt();

        while (true) {
            int number = sc.nextInt();
            if (number != 42) {
                System.out.println(number);
            } else {
                break;
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