import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int cases = sc.nextInt();

        while (--cases >= 0) {
            int n = sc.nextInt(); // Jellyfish apples
            int m = sc.nextInt(); // Gellyfish apples
            long k = sc.nextLong(); // rounds

            long[] japples = new long[n];
            long sumjapple = 0;
            for (int i = 0; i < n; i++) {
                japples[i] = sc.nextLong();
                sumjapple += japples[i];
            }
            Arrays.sort(japples);
    
            long[] gapples = new long[m];
            for (int i = 0; i < m; i++) {
                gapples[i] = sc.nextLong();
            }
            Arrays.sort(gapples); 
    
            long minjapple = japples[0];
            long maxjapple = japples[n-1];
            long mingapple = gapples[0];
            long maxgapple = gapples[m-1];

        if (k == 1) {
            System.out.println(sumjapple - minjapple + Math.max(maxgapple - minjapple, 0));
        } else {
            long gNextBestMove = Math.max(maxgapple - (maxgapple == minjapple ? japples[1] : minjapple), maxjapple - mingapple);
            System.out.println(sumjapple - minjapple + Math.max(maxgapple - minjapple, 0) + (k % 2 == 0 ? gNextBestMove : 0));
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