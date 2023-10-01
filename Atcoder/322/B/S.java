import java.util.*;
import java.io.*;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        String strS = sc.nextLine();
        String strT = sc.nextLine();

        
        if (strT.startsWith(strS) && strT.endsWith(strS)) {
            System.out.println(0);
        } else if (strT.startsWith(strS)) {
            System.out.println(1);
        } else if (strT.endsWith(strS)) {
            System.out.println(2);
        } else {
            System.out.println(3);
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