import java.util.*;
import java.io.*;

class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int players = sc.nextInt();
        var playersArr = new Record[players];

        for (int i = 0; i < players; i++) {
            String result = sc.nextLine();
            
            playersArr[i] = new Record(i, 0);
            for (char c: result.toCharArray()) {
                if (c == 'o') {
                    playersArr[i].wins++;
                    //map.put(i, map.getOrDefault(i, 0)+1);
                }
            }
        }

        Arrays.sort(playersArr); // desc by num of wins, or asc by player num

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players; i++) {
            sb.append(playersArr[i].playerNumber + 1);
            if (i != players-1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static class Record implements Comparable<Record> {
        public int playerNumber;
        public int wins;

        Record(int number, int wins) {
            this.playerNumber = number;
            this.wins = wins;
        }

        @Override
        public int compareTo(Record other) {
            if (this.wins != other.wins) {
                return other.wins - this.wins;
            }
            return this.playerNumber - other.playerNumber; 
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