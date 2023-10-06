import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] nums = {a, b, c};
        Arrays.sort(nums);

        int min = nums[0];
        // int max = Math.max(a, Math.max(b, c));
        // int mid = a+b+c - min - max;

        int res = -1;

        if (n == min) {
            res = 1;
        }

        for (int i = 0; i < 3; i++) {
            int div = nums[i];
            int divRes = n/div;
            int rem = n % div;
            if (divRes < 1) {
                break;
            }

            if (rem == 0) {
                res = divRes;
                break;
            }
            while (rem != 0) {
                for (int j = i+1; j < 3; j++) {
                    
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