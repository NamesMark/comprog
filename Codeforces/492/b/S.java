import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int lant = sc.nextInt();
        int len = sc.nextInt();

        SortedSet<Integer> set = new TreeSet<>();

        while (--lant >= 0) {
            int currLant = sc.nextInt();
            set.add(currLant);
        }

        double maxDist = 0;
        int prev = 0;
        for (int l: set) {
            maxDist = Math.max(l-prev, maxDist);
            prev = l;
        }
        maxDist = maxDist/2;
        maxDist = Math.max(maxDist, set.first());
        maxDist = Math.max(maxDist, len-set.last());

        System.out.println(maxDist);

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