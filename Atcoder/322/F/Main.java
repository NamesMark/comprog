import java.util.*;
import java.io.*;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int len = sc.nextInt();
        int numQueries = sc.nextInt();
        String str = sc.nextLine();
        //System.out.println(str);

        for (int i = 0; i < numQueries; i++) {

            int type = sc.nextInt();

            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            

            if (type == 1) {
                StringBuilder sb = new StringBuilder(str);
                for (int j = start; j <= end; j++) {
                    char c = sb.charAt(j);
                    if (c == '0') {
                        sb.setCharAt(j, '1');
                    } else if (c == '1') {
                        sb.setCharAt(j, '0');
                    }
                }
                str =  sb.toString();
                //System.out.println(str);
                
            } else {
                int maxConsecutive = 0;
                int currConsecutive = 0;
                for (int j = start; j <= end; j++) {
                    if (str.charAt(j) == '0') {
                        currConsecutive = 0;
                    } else {
                        currConsecutive++;
                        maxConsecutive = Math.max(maxConsecutive, currConsecutive);
                    }
                }
                System.out.println(maxConsecutive);
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