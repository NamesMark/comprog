import java.util.*;
import java.io.*;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int numPlans = sc.nextInt();
        int numParameters = sc.nextInt();
        int target = sc.nextInt();

        int[] parameters = new int[numParameters+1];

        int[][] plans = new int[numPlans][numParameters+1];

        for (int i = 0; i < numPlans; i++) {
            for (int j = 0; j < numParameters+1; j++) {
                plans[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(plans, (a, b) -> Integer.compare(a[0], b[0]));

        int totalCost = 0;

        for (int i = 0; i < numPlans; i++) {
            totalCost += plans[i][0];
            for (int j = 1; j < numParameters+1; j++) {
                parameters[j] += plans[i][j];
            }
            
            boolean allGood = true;
            for (int j = 1; j < numParameters+1; j++) {
                if (parameters[j] < target) {
                    allGood = false;
                }
            }
            if (allGood) {
                break;
            }

        }

        boolean allGood = true;
        for (int j = 1; j < numParameters+1; j++) {
            if (parameters[j] < target) {
                allGood = false;
            }
        }
        if (allGood) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
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