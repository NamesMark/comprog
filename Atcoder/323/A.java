import java.util.*;
import java.io.*;

class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        String str = sc.nextLine();
        
        boolean res = true;

        for (int i = 1; i < 16; i += 2) {
            if (str.charAt(i) == '1') {
                //System.out.println(i+", "+str.charAt(i));
                res = false;
                break;
            }
        }
        
        if (res) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
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