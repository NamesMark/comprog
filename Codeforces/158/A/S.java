import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    // public static void solve(int n) {

        
    // }

    public static void main(String[] args) {
        int participants = sc.nextInt();
        int k = sc.nextInt();

        int res = 0;
        int[] parArray = new int[participants];
        for (int i = 0; i < participants; i++) {
            parArray[i] = sc.nextInt();
        }

        if (k == 0 || parArray[0] == 0) {
            res = 0;
        } else {
            int mate = -1;
            res = 0;

            for (int i = 0; i < participants; i++) {
                if (parArray[i] == 0) {
                    break;
                }

                if (i == k-1) {
                    mate = parArray[k-1];
                }

                if (i > k-1) {
                    if (parArray[i] == mate) {
                        res++;
                    } else {
                        break;
                    }
                } else {
                    res++;
                }
            }
        }



        System.out.println(res);

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