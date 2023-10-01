import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void solve(int n) {


        int[] arr = new int[n];

        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + 1;
        }

        for (int i = 2; i < n; i++) {
            while (arr[i] <= arr[i-1]) {
                arr[i]++;
            }
            while ((3 * arr[i]) % (arr[i-2] + arr[i-1]) == 0) {
                arr[i]++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int arrayLength = sc.nextInt();


            solve(arrayLength);
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