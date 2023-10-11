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
		    String inputLine = sc.nextLine();
		    String[] parts = inputLine.split(" ");
            int length = Integer.parseInt(parts[0]);
            
            String nStr = parts[1];
            int lastThree;
            if (length < 2) {
                System.out.println("8");
                continue;
            } else if (length < 3) {
                lastThree = Integer.parseInt(nStr.substring(length - 2));
            } else {
                lastThree = Integer.parseInt(nStr.substring(length - 3));
            }

            if (lastThree % 8 == 0) {
                System.out.println(nStr);
            } else {
                if (length < 2) {
                    System.out.println(8);
                } else {
                    int res = lastThree;
                    int hundreds = lastThree / 100;
                    int tens = (lastThree / 10) % 10;
                    int ones = lastThree % 10;
                    find:while (true) {
                        // 1 change: ones 
                        for (int i = 0; i < 10; i++) {
                            int newThree = hundreds*100 + tens*10 + i;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        // 1 change: tens
                        for (int i = 0; i < 10; i++) {
                            int newThree = hundreds*100 + i*10 + ones;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        // 1 change: hundreds
                        for (int i = 0; i < 10; i++) {
                            int newThree = i*100 + tens*10 + ones;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        // 2 changes: last 2 digits
                        for (int i = 0; i < 100; i++) {
                            int newThree = hundreds*100 + i;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        // 2 changes: first 2 digits
                        for (int i = 0; i < 100; i++) {
                            int newThree = i*10 + ones;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        // 2 changes: first and last 
                        for (int x = 0; x < 10; x++) {
                            for (int y = 0; y < 10; y++) {
                                int newThree = x* 100 + tens + y;
                                if (newThree % 8 == 0) {
                                    res = newThree; 
                                    break find;
                                }
                            }
                        }
                        
                        // up to 3 changes:
                        for (int i = 0; i< 1000; i++) {
                            int newThree = i;
                            if (newThree % 8 == 0) {
                                res = newThree; 
                                break find;
                            }
                        }
                        
                    }
                    if (length == 2) {
                        System.out.println(nStr.substring(0, length - 2) + String.format("%02d", res));
                    } else {
                        System.out.println(nStr.substring(0, length - 3) + String.format("%03d", res));
                        
                    }
                }
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
