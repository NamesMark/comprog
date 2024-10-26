import java.util.*;
import java.io.*;

class C {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] gifts = new int[N];
        for (int i = 0; i < N; i++) {
            gifts[i] = sc.nextInt();
        }

        Arrays.sort(gifts);

        int max = 0;
        int start = 0; 
        int end = 0;

        while (end < N) {
            if (gifts[end] < gifts[start] + M) {
                end++;
            } else {
                start++;
            }
            max = Math.max(max, end - start);
        }
        
        System.out.println(max);
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