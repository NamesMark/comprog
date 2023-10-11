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
		    Integer[] aliceRolls = new Integer[3];
		    Integer[] bobRolls = new Integer[3];
		    
		    for (int i = 0 ; i<3; i++) {
		        aliceRolls[i] = sc.nextInt();
		    }
		    
		    for (int i = 0 ; i<3; i++) {
		        bobRolls[i] = sc.nextInt();
		    }
		    
		    Arrays.sort(aliceRolls, Collections.reverseOrder());
		    Arrays.sort(bobRolls, Collections.reverseOrder());
		    
		    int aliceRes = Integer.parseInt("" + aliceRolls[0] + aliceRolls[1] + aliceRolls[2]);
		    int bobRes = Integer.parseInt("" + bobRolls[0] + bobRolls[1] + bobRolls[2]);
		    
		    if (aliceRes > bobRes) {
		        System.out.println("Alice");
		    } else if (aliceRes < bobRes) {
		        System.out.println("Bob");
		    } else {
		        System.out.println("Tie");
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
