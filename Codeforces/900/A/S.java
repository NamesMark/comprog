import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    // public static void solve(int n, int mostCommon, long[] arr) {

    //     int res = -1;





	// 	System.out.println(res);
    // }

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int arrayLength = sc.nextInt();
            int target = sc.nextInt();

            long[] testCaseArray = new long[arrayLength];
            boolean exists = false;

            for (int i = 0; i < arrayLength; i++) {
                testCaseArray[i] = sc.nextLong();
                if (testCaseArray[i] == target) {
                    exists = true;
                }
            }
            //System.out.println("Target was " + target + " and it exists - " + exists);
            if (exists) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            // solve(arrayLength, mostCommon, testCaseArray);

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