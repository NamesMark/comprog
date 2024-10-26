import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            if (n % 2 != 0) {
                for (int i = 0; i < n; i++) sc.nextInt();  // Skip input
                System.out.println("No");
                continue;
            }

            Arrays.sort(nums);

            boolean res = true;

            if (n != 2) {
                int k = nums[0] + nums[n-1];
                for (int i = 0; i < n/2; i++) {
                    //System.out.printf("K is %d, nums[i] + nums[n-1-i] = %d + %d = %d %n", k, nums[i], nums[n-1-i], nums[i] + nums[n-1-i]);
                    if (nums[i] + nums[n-1-i] != k) {
                        res = false;
                        break;
                    }
                }
            }

            System.out.println(res ? "Yes" : "No");
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