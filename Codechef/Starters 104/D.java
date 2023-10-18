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
            long[] arr = new long[n];
            long max = Integer.MIN_VALUE;
            //long maxI = -1;
            long second_max = Integer.MIN_VALUE;
            //long second_maxI = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                if (arr[i] >= max) {
                    second_max = max;
                    //second_maxI = maxI;
                    max = arr[i];
                    //maxI = i;

                } else if (arr[i] > second_max) {
                    second_max = arr[i];
                }
            }
            long res = 0;

            if (n == 1) {
                res = arr[0];
            } if (n == 2) {
                res = arr[0] + arr[1];
            } else {
                res = (n-1)*second_max + max;
            }

            System.out.println(res);
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
