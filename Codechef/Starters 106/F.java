/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
	public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader sc = new FastReader();
		int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt() -1;
            int y = sc.nextInt() -1;
            
            int[][] grid = new int[n][m];
            grid[x][y] = 1;
            int vx, vy;
            if (x < n/2) {
                vx = x+1;
            } else {
                vx = x-1;
            }
            if (y < m/2) {
                vy = y+1;
            } else {
                vy = y-1;
            }

            grid[vx][vy] = 2;

            int numInf = 1;
            int numVac = 1;
            while ((numInf + numVac) < n*m) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == 1) {
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d];
                                int ny = i + dx[d];
                                if (nx < 0 || nx >=n || ny < 0 || ny >= m) {
                                    continue;
                                }
                                if (grid[nx][ny] != 0) {
                                    continue;
                                }
                                grid[nx][ny] = 1;
                                numInf++;
                            }
                        }
                        if (grid[i][j] == 2) {
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d];
                                int ny = i + dx[d];
                                if (nx < 0 || nx >=n || ny < 0 || ny >= m) {
                                    continue;
                                }
                                if (grid[nx][ny] != 0) {
                                    continue;
                                }
                                grid[nx][ny] = 2;
                                numVac++;
                            }
                        }
                    }
                }
            }

            pr(numVac);
            
        }

	}

    private static <T> void pr(T str) {
        System.out.println(str);
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
