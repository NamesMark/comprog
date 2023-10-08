import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            
            int saved = 0;
            int[] canShare = new int[n];
            for (int i = 0; i < n; i++) {
                canShare[i] = sc.nextInt();
            }

            int[] shareCost = new int[n];
            for (int i = 0; i < n; i++) {
                int cost = sc.nextInt();
                shareCost[i] = cost;
                // while (cost < p && sharedTo < n && canShare[i]>0) {
                //     // saved+= (p-cost)*(Math.min(canShare[i], n-sharedTo));
                //     saved += (p-cost);
                //     sharedTo++;
                //     canShare[i]--;
                // }
            }

            Villager[] villagers = new Villager[n];
            for (int i = 0; i < n; i++) {
                villagers[i] = new Villager(canShare[i], shareCost[i]);
            }

            Arrays.sort(villagers, Comparator.comparingInt(v -> v.cost));

            int sharedTo = 1;

            for (int i = 0; i < n; i++) {
                int cost = villagers[i].cost;
                int share = villagers[i].canShare;

                while (cost < p && sharedTo < n && share>0) {
                    saved += (p-cost);
                    sharedTo++;
                    share--;
                }
            }

            System.out.println((p*n - saved));
        }
    }

    static class Villager {
        public int canShare;
        public int cost;

        Villager(int canShare, int cost) {
            this.canShare = canShare;
            this.cost = cost;
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