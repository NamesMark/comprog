/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    private static final Map<List<Integer>, Integer> gcdCache = new HashMap<>();
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader sc = new FastReader();
		int t = sc.nextInt();

        while (--t >= 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            
            int res = 0;
            int min = Math.min(x,y);
            int max = Math.max(x,y);

            if (x == y) {
                res = x + y;
            } else {
                for (int i = 0; i < k; i++) {
                    int currentGCD = gcd(x, y);

                    // option 1
                    int x1 = currentGCD;            // x replaced with gcd 
                    int y1 = (x1 / gcd(x1,y)) * y;  // lcm with new x
                    
                    // option 2
                    int y2 = currentGCD;            // y replaced with gcd
                    int x2 = (x / gcd(x,y2)) * y2;  // lcm with new y
                    
                    if (x1+y1 <= x2+y2) {
                        x = x1;
                        y = y1;
                    } else {
                        x = x2;
                        y = y2;
                    }
                    if (x == y) {
                        break;
                    }

                }
                res = x+y;
            }
            System.out.println(res);
        }

	}

    static int gcd(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        List<Integer> key = Arrays.asList(a, b);
        if (gcdCache.containsKey(key)) {
            return gcdCache.get(key);
        }
        
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }

        gcdCache.put(key, a);
        
        return a;
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
