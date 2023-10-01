import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int arraySize = sc.nextInt();

        int even = 0;
        int odd = 0;
        int lastEven = -1;
        int lastOdd = -1;

        int res = -1;

        for (int i = 1; i <= arraySize; i++) {
            int curr = sc.nextInt();
            if (curr % 2 == 0) {
                even++;
                lastEven = i;
            } else {
                odd++;
                lastOdd = i;
            }
            if (res == -1 && even > 1 && lastOdd != -1) {
                res = lastOdd;
            } else if (res == -1 && odd > 1 && lastEven != -1) {
                res = lastEven;
            }
            
        }
        System.out.println(res);
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