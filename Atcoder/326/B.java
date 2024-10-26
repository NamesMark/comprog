import java.util.*;
import java.io.*;

class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int N = sc.nextInt();
        
        int res = 0;
        for (int i = N; i<=919; i++) {
            if (is326(i)) {
                res = i;
                break;
            }
        }

        System.out.println(res);
    }

    private static boolean is326(int n) {
        int hun = n / 100;
        int dec = (n / 10) % 10;
        int one = n % 10;

        // if (hun*dec == one) {
        //     System.out.println(n);
        // }

        return hun*dec == one;
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