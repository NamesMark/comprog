import java.util.*;
import java.io.*;

public class PRIME1 {

    static FastReader sc = new FastReader();

    
    public static void main(String[] args) throws java.lang.Exception {
        
        int cases = sc.nextInt();
        Map<Integer, Boolean> primeMap = new HashMap<>();

        while (--cases >= 0) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            for (int i = min; i <= max; i++) {
                if (isPrime(i, primeMap)) {
                    System.out.println(i);
                }
            }
        }

    }

    static boolean isPrime(int num, Map<Integer, Boolean> primeMap) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        if (primeMap.containsKey(num)) {
            return primeMap.get(num);
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                primeMap.put(num, false);
                return false;
            }
        }
        primeMap.put(num, true);
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