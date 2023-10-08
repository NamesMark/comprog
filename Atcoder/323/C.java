import java.util.*;
import java.io.*;

class C {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int players = sc.nextInt();
        int problems = sc.nextInt();

        int[] probValues = new int[problems];

        for (int i = 0; i < problems; i++) {
            probValues[i] = sc.nextInt();
        }
        
        var playersScores = new int[players];
        PriorityQueue<Integer>[] playersUnsolved = new PriorityQueue[players];

        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < players; i++) {
            String result = sc.nextLine();
            playersUnsolved[i] = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
            
            for (int j = 0; j < problems; j++) {
                if (result.charAt(j) == 'o') {
                    playersScores[i] += probValues[j]; 
                } else {
                    playersUnsolved[i].add(probValues[j]);
                }
            }
            playersScores[i] += i;

            maxScore = Math.max(maxScore, playersScores[i]);
        }

        for (int i = 0; i < players; i++) {
            if (playersScores[i] == maxScore) {
                System.out.println(0);
                continue;
            }
            int addCount = 0;
            int diff = maxScore-playersScores[i];
            while (diff>0 && !playersUnsolved[i].isEmpty()) {
                addCount++;
                diff -= playersUnsolved[i].poll();
            }
            System.out.println(addCount);
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