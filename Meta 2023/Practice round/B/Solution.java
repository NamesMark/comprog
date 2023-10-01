import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n, int[] arr, int caseNumber) {

        long r = arr[0];
        long c = arr[1];
        long a = arr[2];
        long b = arr[3];




        String result;
        if (r>c) {
            result = "YES";
        } else {
            result = "NO";
        }

		System.out.println("Case #"+ caseNumber +": " + result);
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
		int totalTestCases = testCases;
        while (testCases-- > 0) {
            int inputLength = 4;
            // int inputLength = sc.nextInt();
            //int k = sc.nextInt();
            // long[] testCaseArray = new long[inputLength];
            // for (int i = 0; i < inputLength; i++) {
            //     testCaseArray[i] = sc.nextLong();
            // }
            int[] testCaseArray = new int[inputLength];
            for (int i = 0; i < inputLength; i++) {
                testCaseArray[i] = sc.nextInt();
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