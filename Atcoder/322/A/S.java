import java.util.*;
import java.io.*;

class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int length = sc.nextInt();

        String str = sc.nextLine();

        
        int idx = str.indexOf("ABC");

        if (idx == -1) {
            System.out.println(-1);
        } else {
            System.out.println(idx+1);
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