import java.util.*;
import java.io.*;

class D {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int sizes = sc.nextInt();
        var slimes = new TreeMap<Integer, Integer>();

        for (int i = 0; i < sizes; i++) {
            int size = sc.nextInt();
            int num = sc.nextInt();

            slimes.put(size, num);
        }

        boolean merged = true;

        while (merged) {
            merged = false;
            TreeMap<Integer, Integer> newEntries = new TreeMap<>();

            for (Map.Entry<Integer, Integer> entry: new ArrayList<>(slimes.entrySet())) {
                int size = entry.getKey();
                int num = entry.getValue();
        
                if (num <= 1) continue;
        
                int pairsToMerge = num / 2; 
                int remainder = num % 2;
        
                merged = true;
        
                if (remainder == 0) {
                    slimes.remove(size);
                } else {
                    slimes.put(size, remainder);
                }
        
                newEntries.put(size * 2, newEntries.getOrDefault(size * 2, 0) + pairsToMerge);
            }
            for (Map.Entry<Integer, Integer> entry : newEntries.entrySet()) {
                slimes.put(entry.getKey(), slimes.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        int minNum = 0;
        for (Map.Entry<Integer, Integer> entry: slimes.entrySet()) {
            minNum += entry.getValue();
        }

        System.out.println(minNum);

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