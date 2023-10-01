import java.util.*;
import java.io.*;

public class Template3 {

    static FastReader sc = new FastReader();

    public static void solve(int n, int k, int[] arr) {
        System.out.println();
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int inputLength = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[inputLength];
            for (int i = 0; i < inputLength; i++) {
                arr[i] = sc.nextInt();
            }
            solve(inputLength, k, arr);
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