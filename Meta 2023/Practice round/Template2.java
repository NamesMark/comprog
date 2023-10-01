import java.util.*;
import java.io.*;
 
public class Template2 {
    // static Scanner sc = new Scanner(System.in);
    static Set<Integer> set = new HashSet<>();
    static FastReader sc = new FastReader();
 
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

 
    public static void solve() {
 
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

 
        System.out.println( );
    }
 
    public static void main(String[] args) {
        int t = sc.nextInt();
        // call();
        // System.out.println((3 | 5 | 6 | 2) ^ 15);
        while (t > 0) {
            t--;
            solve();
        }
        // sc.close();
 
    }
}