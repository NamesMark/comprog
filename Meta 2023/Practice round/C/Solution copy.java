import java.util.*;
import java.io.*;

public class Solution {

    static FastReader sc = new FastReader();

    public static void solve(int n, int length, int[] arr, int caseNumber) {

        int[] mutArray = arr;

        int mutN = n;

        Arrays.sort(mutArray);

        // Map<Integer, Integer> map = new HashMap<>();

        // for (int num: mutArray) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        int sumCandidate = -1;
        boolean pairlessSeen = false;
        int[] pairlessIdxs = new int[2];
        int left = 0;
        int right = length-1;

        int result = 0;
        
        while (left <= right) {
            int newSum = mutArray[left]+mutArray[right];
            if (sumCandidate != -1 && newSum != sumCandidate) {
                if (pairlessSeen) {
                    result = -1;
                } else {
                    pairlessSeen = true;
                    pairlessIdxs[0] = left;
                    pairlessIdxs[1] = right;
                }
            } 
        }
        







        if (result <= 0) {
            result = -1;
        }
        // } else {
        //     result = "NO";
        // }

		System.out.println("Case #"+ caseNumber +": " + result);
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();
		int totalTestCases = testCases;
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int inputLength = n*2 - 1;
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
            solve(n, inputLength, testCaseArray, caseNumber);
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