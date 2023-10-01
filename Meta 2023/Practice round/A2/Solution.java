import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n, long[] arr, int caseNumber) {

        long a = arr[0];
        long b = arr[1];
        long c = arr[2];

        long singles = 0;
        long doubles = 0;

        doubles = c/b;
        long remaining = c % b;
        singles = remaining / a;

        long avlPats = singles + doubles * 2;
        long avlBuns = (singles + doubles) * 2;

        long k1 = avlPats;
        while (avlBuns < k1+1) {
            k1--;
        }

        singles = c/a;
        remaining = c % a;
        doubles = remaining / b;

        avlPats =  singles + doubles * 2;
        avlBuns = (singles + doubles) * 2;

        long k2 = avlPats;
        while (avlBuns < k2+1) {
            k2--;
        }

        long k3 = 0;
        if (c >= a) {
            singles = 1;
            remaining = c - a;
            if (remaining > 0) {
            doubles = remaining / b;
            } else {
                doubles = 0;
            }

            avlPats =  singles + doubles * 2;
            avlBuns = (singles + doubles) * 2;

            k3 = avlPats;
            while (avlBuns < k3+1) {
                k3--;
            }
        } else {
            k3 = 0;
        }
        
        long k4 = 0;
        if (c >= 2*a) {
            singles = 2;
            remaining = c - 2*a;
            if (remaining > 0) {
                doubles = remaining / b;
            } else {
                doubles = 0;
            }

            avlPats =  singles + doubles * 2;
            avlBuns = (singles + doubles) * 2;

            k4 = avlPats;
            while (avlBuns < k4+1) {
                k4--;
            }
        } else {
            k4 = 0;
        }
        
        long[] resultCandidates = new long[] {k1, k2, k3, k4};
        long k = Long.MIN_VALUE;
        for (long result:resultCandidates) {
            k = Math.max(k, result);
        }

        //long k = Math.max(k1, k2);

        if (k == -1) {
            k = 0;
        }

        // System.out.println("\n!!! Case #"+ caseNumber + ":");
        // System.out.println("A: " + a + ", B: " + b + ", C: " + c);
        // System.out.println("k1 "+ k1 + ", k2 "+ k2);
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