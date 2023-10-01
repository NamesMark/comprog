import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int operations = sc.nextInt();
        
        int x = 0;

        while (--operations >= 0) {
            String op = sc.nextLine();

            x+= switch (op) {
                case "--X", "X--" -> -1;
                case "++X", "X++" -> 1;
                default -> 0;
            };
        }

        System.out.println(x);

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