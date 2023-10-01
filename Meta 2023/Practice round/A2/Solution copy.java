import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n, long[] arr, int caseNumber) {

        long a = arr[0];
        long b = arr[1];
        long c = arr[2];

        long pricePerPattyA = a;
        long pricePerPattyB = b/2;

        long singles = 0;
        long doubles = 0;

        if (pricePerPattyB <= pricePerPattyA) {
            doubles = c/b;
            long remaining = c % b;
            singles = remaining / a;
        } else {
            singles = c/a;
            long remaining = c % a;
            doubles = remaining / b;
        }

        long avlPats = singles+doubles*2;
        long avlBuns = (singles+doubles)*2;

        long k = avlPats;
        while (avlBuns < k * 2) {
            k--;
        }

		System.out.println("Case #"+ caseNumber +": " + k);
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
		int totalTestCases = testCases;
        while (testCases-- > 0) {
            int inputLength = 3;
            // int inputLength = sc.nextInt();
            //int k = sc.nextInt();
            long[] testCaseArray = new long[inputLength];
            for (int i = 0; i < inputLength; i++) {
                testCaseArray[i] = sc.nextLong();
            }
			int caseNumber = totalTestCases-testCases;
            solve(inputLength, testCaseArray, caseNumber);
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