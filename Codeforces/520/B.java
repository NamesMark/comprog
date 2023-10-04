import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int init = sc.nextInt();
        int targ = sc.nextInt();

        int res = 0;
        //System.out.println("1 init: "+init+", targ: "+targ);
        while (targ > init) {
            //System.out.println("2 init: "+init+", targ: "+targ+", res: "+res);
            if (targ % 2 == 0) {
                targ /= 2;
                res++;
            } else {
                targ++;
                res++;
            }
        }
        //System.out.println("3 init: "+init+", targ: "+targ+", res: "+res);
        res += init-targ;
        //System.out.println("4 init: "+init+", targ: "+targ+", res: "+res);

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