import java.util.*;
import java.io.*;

class D {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int N = sc.nextInt();
        
        String R = sc.nextLine();
        String C = sc.nextLine();

        char[][] grid = new char[N][N];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        boolean res = true;

        if (R.charAt(0) != C.charAt(0)) {
            res = false;
        } else {
            grid[0][0] = R.charAt(0);
            for (int i = 1; i < N; i++) {
                grid[i][0] = R.charAt(i);
                grid[0][i] = C.charAt(i);
            }
        }
        if (res) {
            res = fillGrid(grid, 0, 1, N);
        }

        if (res) {
            System.out.println("Yes");
            for (char[] row : grid) {
                for (char ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        } else {
            for (char[] row : grid) {
                for (char ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            System.out.println("No");
        }
    }

    private static boolean fillGrid(char[][] grid, int row, int col, int N) {
        if (row == N) {
            return true;
        }
        if (col == N) {
            return fillGrid(grid, row+1, 0, N);
        }
        if (grid[row][col] != '.') {
            return fillGrid(grid, row, col+1, N);
        }
        
        for (char ch : new char[]{'A', 'B', 'C'}) {
            if (canPlace(grid, row, col, ch, N)) {
                grid[row][col] = ch;
                if (fillGrid(grid, row, col + 1, N)) {
                    return true;
                }
                grid[row][col] = '.';
            }
        }
        return false; 
    }
    
    private static boolean canPlace(char[][] grid, int row, int col, char ch, int N) {
        for (int i = 0; i < N; i++) {
            if (grid[row][i] == ch || grid[i][col] == ch) return false;
        }
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