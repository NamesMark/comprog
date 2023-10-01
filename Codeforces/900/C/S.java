import java.util.*;
import java.io.*;

public class S {

    static FastReader sc = new FastReader();

    static Map<Integer, Long> maxMap = new HashMap();
    static Map<Integer, Long> minMap = new HashMap();

    private static long maxPossible(int num) {
        if (maxMap.containsKey(num)) {
            return maxMap.get(num);
        }
        long res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        maxMap.put(num, res);
        return res;
    }

    private static long minPossible(int num) {
        if (minMap.containsKey(num)) {
            return minMap.get(num);
        }
        long res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        minMap.put(num, res);
        return res;
    }


    public static void solve(int max, int num, long sum) {

        boolean res = false;


        if (sum > maxPossible(max)) {
            res = false;
        } else if (sum < minPossible(num)) {
            res = false;
        } else {
            long testSum = 0;
            int used = 0;
            int i = max;

            while (i > 0 && used < num) {
                used++;
                testSum += i;
                if (testSum == sum) {
                    res = true;
                    break;
                } else if (testSum > sum) {
                    testSum -= i;
                    used--;
                }
                i--;
            }
        }



		if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int max = sc.nextInt();
            int num = sc.nextInt();
            long sum = sc.nextLong();
            

            solve(max, num, sum);
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