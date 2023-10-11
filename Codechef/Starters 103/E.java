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
		int cases = sc.nextInt();
		
		while (--cases >= 0) {
		    String line = sc.nextLine();
		    String binStr = sc.nextLine();
		    
		    String[] lineParts = line.split(" ");
		    int length = Integer.parseInt(lineParts[0]);
		    int k = Integer.parseInt(lineParts[1]);
		    
		    int ones = 0;
		    int zeros = 0;
		    
		    for (char c: binStr.toCharArray()) {
		        if (c == '1') {
		            ones++;
                }
		    }
		    zeros = length-ones;

		    if (ones == length || zeros == length) {
		        System.out.println(0);
		        continue;
		    } 
		    
		    int[] modCounts = new int[k];
        
            for (int i = 0; i < length; i++) {
                if (binStr.charAt(i) == '1') {
                    modCounts[i % k]++;
                }
            }
    
            int minOperations = Integer.MAX_VALUE;
    
            for (int i = 0; i < k; i++) {
                int totalOnes = 0;
                for (int count : modCounts) {
                    totalOnes += count; 
                }
                int operations = totalOnes - modCounts[i] + (length/k - modCounts[i]);
                minOperations = Math.min(minOperations, operations);
            }
            
            System.out.println(minOperations);
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
