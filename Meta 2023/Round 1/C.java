import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class C {

    //static FastReader sc = new FastReader();
    final static String INPUT_FILE = "C_sample.txt";
    final static String OUTPUT_FILE = "C_sample_out.txt";

    private static StringWriter output;
    private static PrintWriter outputWriter;

    public static void main(String[] args) {
        FastReader sc = null;
        try {
            sc = new FastReader(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }     
        output = new StringWriter();
        outputWriter = new PrintWriter(output);
        
        int cases = sc.nextInt();

        for (int c = 0; c < cases; c++) {

            int n = sc.nextInt();
            StringBuilder bit = new StringBuilder(sc.nextLine());
            int q = sc.nextInt();
            int[] broops = new int[q];
            for (int i = 0; i < q; i++) {
                broops[i] = sc.nextInt();
            }

            for (int i = 0; i < q; i++) {
                int op = broops[i];

                for (int o = op; o < n; o += op) {
                    if (bit.charAt(o) == '0') {
                        bit.setCharAt(o, '1');
                    } else {
                        bit.setCharAt(o, '0');
                    }
                }
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (bit.charAt(i-1) == '1') {
                    result++;
                    for (int o = i; o < n; o += i) {
                        if (bit.charAt(o-1) == '0') {
                            bit.setCharAt(o-1, '1');
                        } else {
                            bit.setCharAt(o-1, '0');
                        }
                    }
                }
            }

            outputWriter.println("Case #" + c + ": " + result);
        }

        outputWriter.close();
        writeOutputToFile(output.toString().trim(), OUTPUT_FILE);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String inputFile) throws IOException {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(inputFile);
            if (resourceAsStream == null) {
                throw new IOException(inputFile + " not found");
            }
            br = new BufferedReader(new InputStreamReader(resourceAsStream));
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

    private static void writeOutputToFile(String content, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.print(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}