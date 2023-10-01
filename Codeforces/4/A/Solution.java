import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n) {

        if (n > 2 && n % 2 == 0) {
            System.out.println("YES");
            return;
        } else {
            System.out.println("NO");
            return;
        }

		//System.out.println("Case #"+ caseNumber +": " + k);
    }

    public static void main(String[] args) {
        //int testCases = sc.nextInt();
        int testCases = 1;
		// int totalTestCases = testCases;
        // while (testCases-- > 0) {
        //     int inputLength = 3;
        //     // int inputLength = sc.nextInt();
        //     //int k = sc.nextInt();
        //     long[] testCaseArray = new long[inputLength];
        //     for (int i = 0; i < inputLength; i++) {
        //         testCaseArray[i] = sc.nextLong();
        //     }
		// 	int caseNumber = totalTestCases-testCases;
            // solve(inputLength, testCaseArray, caseNumber);
            int input = sc.nextInt();
            solve(input);
        //}
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