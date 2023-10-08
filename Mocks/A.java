import java.util.*;
import java.io.*;

public class A {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        
        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // int[][] testMatrix = {
        //     {7, 4, 1},
        //     {8, 5, 2},
        //     {9, 6, 3}
        // };
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[][] testMatrix = {
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4}
        };

        matrix = rotate(matrix);

        boolean solved = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (testMatrix[i][j] != matrix[i][j]) {
                    solved = false;
                }
            }
        }
        System.out.println("Solved! - "+solved);

    }

    private static void printMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // only works on 3x3 and 4x4 matrices ;_;
    public static int[][] rotate(int[][] matrix) {
        int N = matrix.length;
        System.out.println("Input:");
        printMatrix(matrix);
        
        // reversing rows
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-j-1];
                matrix[i][N-j-1] = temp;
            }
        }
        System.out.println("1. Reversed rows: ");
        printMatrix(matrix);

        for (int i = 0; i < N/2; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[N-1-i][N-1-i];
            matrix[N-1-i][N-1-i] = temp;
        }
        System.out.println("2. Main diagonal reversed (hopefully): ");
        printMatrix(matrix);

        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][N-1-i];
                matrix[N-1-j][N-1-i] = temp;
            }
        }
        System.out.println("3. Lower diagonals: ");
        printMatrix(matrix);


        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = temp;
            }
        }
        System.out.println("4. Upper diagonals: ");
        printMatrix(matrix);

        // i = 0 1 2
        // j = 0 1 2

        // i = 1 2 3
        // j = 0 1 2

        // 0,0 -> 3,3; 1,1 -> 2,2
        // 1,0 -> 3,2; 2,1 -> 2,1

    
    //     i = 0 -> n-1
    //        ii = i
    //        j = i -> n/2
    //             m[i][j] (swap) m[n-i][n-j]
    //              ii++


        return matrix;
    }





    private static <T> void assertEquals(T element1, T element2) {
        if (!element1.equals(element2)) {
            //throw new AssertionError("Expected " + element2 + "\n but got: \n" + element1);
            System.out.println("Expected " + element2 + "\n but got: \n" + element1);
            return;
        }
        System.out.println("! Test passed !");
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