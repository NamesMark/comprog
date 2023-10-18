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
            int numChild = sc.nextInt();
            int maxDiff = sc.nextInt();
            int[] distrib = new int[numChild];
            int sum = 0;
            for (int i = 0 ; i < numChild; i++) {
                distrib[i] = sc.nextInt();
                sum += distrib[i];
            }

            boolean res = false;;
            if (sum >= numChild) {
                //if (sum % numChild <= maxDiff) {
                if (maxDiff >= 1 || sum % numChild == 0) {
                    res = true;
                }
            } else {
                res = false;
            }

            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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
