import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n, int[] arr, int caseNumber) {

		int avlBuns = arr[0]*2 + arr[1]*2;
		int avlPats = arr[0]*1 + arr[1]*2;
		
		int reqBuns = 1 + arr[2];
		int reqPats = arr[2];

		if (reqBuns <= avlBuns && reqPats <= avlPats) {
			System.out.println("Case #"+ caseNumber +": YES");
		} else {
			System.out.println("Case #"+ caseNumber +": NO");
		}
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
		int totalTestCases = testCases;
        while (testCases-- > 0) {
            int inputLength = 3;
            // int inputLength = sc.nextInt();
            //int k = sc.nextInt();
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