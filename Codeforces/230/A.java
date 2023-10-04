import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int heroStr = sc.nextInt();
        int n = sc.nextInt();

        boolean victory = true;

        List<Dragon> dragons = new ArrayList<>();

        while (--n >= 0) {
            int str = sc.nextInt();
            int bonus = sc.nextInt();
            dragons.add(new Dragon(str, bonus));
        }

        Collections.sort(dragons, (a, b) -> a.str - b.str);

        for (Dragon dragon: dragons) {

            if (heroStr <= dragon.str) {
                victory = false;
                break;
            } else {
                heroStr += dragon.bonus;
            }
        }

        if (victory) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static class Dragon {
        public int str;
        public int bonus;

        public Dragon (int str, int bonus) {
            this.str = str;
            this.bonus = bonus;
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