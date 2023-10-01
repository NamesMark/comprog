import java.util.*;
import java.io.*;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mm = m;

        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int launch = sc.nextInt();
            days[launch-1] = 0;
        }

        days[n-1] = 0;

        int lastLaunch = n;
        for (int i = n-1; i >= 0; i--) {
            if (days[i]==0) {
                lastLaunch = i;
            } else {
                days[i] = lastLaunch-i;
            }
        }

        for (int d: days) {
            System.out.println(d);
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