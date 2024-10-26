import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int T = sc.nextInt();

        while (--T >= 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String s = sc.nextLine();
            String t = sc.nextLine();


            boolean res = false;

            if (isGood(s)) { // s already good
                res = true;
            } else {          
                if (isGood(t)) {    // t is only helpful if good 
                    boolean zeroProblem = false;
                    boolean oneProblem = false;
                    for (int i = 0; i < n-1; i++) {
                        if (s.charAt(i) == s.charAt(i+1)) {
                            if (s.charAt(i) == '0') {
                                zeroProblem = true;
                            } else {
                                oneProblem = true;
                            }
                        }
                    }
                    if (!(zeroProblem && oneProblem)) { // can only save if one problem 
                        if (t.charAt(0) == t.charAt(m-1)) {   // it's border elements are the same (can be a delimeter)
                            int deliT = t.charAt(0);

                            if (deliT == '0' && oneProblem) { // can be a delimeter between ones
                                res = true;
                            } else if (deliT == '1' && zeroProblem) {    // can be a delimeter between zeros
                                res = true;
                            }
                        }
                    }
                } 
            }

            System.out.println(res ? "Yes" : "No");
        }
    }

    private static boolean isGood (String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                return false;
            }
        }
        return true;
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