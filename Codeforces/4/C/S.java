import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int numCases = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();


        while (--numCases >= 0) {
            String name = sc.nextLine();

            map.put(name, map.getOrDefault(name, 0)+1);
            int count = map.get(name);
            if (map.get(name)>1) {
                System.out.println(name+(count-1));
            } else {
                System.out.println("OK");
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