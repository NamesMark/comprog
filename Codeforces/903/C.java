import java.util.*;
import java.io.*;

public class C {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        int t = sc.nextInt();

        while (--t >= 0) {
            int n = sc.nextInt();
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            char[][] rotatedMatrix = rotate(matrix);

            int res = 0;

            processing:for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int newOps = matrix[i][j] - rotatedMatrix[i][j];
                    //System.out.println("rotated ij - matrix ij: "+rotatedMatrix[i][j]+" - "+matrix[i][j]+" = "+newOps);
                    //System.out.println("i: "+i+", j: "+j+", matrix - rot: "+matrix[i][j]+" - "+rotatedMatrix[i][j]+" = "+newOps);
                    // neutralize this op:
                    matrix[i][j] = rotatedMatrix[i][j];
                    rotatedMatrix = rotate(matrix);

                    // if (newOps < 0) {
                    //     res = -1;
                    //     break processing;
                    // } else {
                    //     res += newOps;
                    // }
                    res += Math.abs(newOps);
                }
            }

            System.out.println(res);

        }

    }

    static char[][] rotate(char[][] matrix) { //90deg rot
        int N = matrix.length;
        char[][] resMatrix = new char[N][N];

        // transpose
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                resMatrix[i][j] = matrix[j][i];
                resMatrix[j][i] = matrix[i][j];
            }
        }
        // reverse 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                resMatrix[i][j] = matrix[i][N-j-1];
                resMatrix[i][N-j-1] = matrix[i][j];
            }
        }

        return resMatrix;
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