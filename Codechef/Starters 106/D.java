/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader sc = new FastReader();
		int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            int k = sc.nextInt(); // len of subarray

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int totalCount = 0;
            for (int i = 0; i <= n-k; i++) {
                //System.out.printf("i %d, num %d%n", i, nums[i]);
                int bOr = nums[i];
                for (int j = 1; j < k; j++) {
                    //System.out.printf("j %d, num %d%n", j, nums[i+j]);
                    bOr |= nums[i+j];
                }
                if (bOr % 2 == 1) {
                    totalCount++;
                }
            }

            pr(totalCount);

        }

	}

    private static <T> void pr(T str) {
        System.out.println(str);
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
