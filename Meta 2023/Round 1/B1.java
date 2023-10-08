import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class B {

    //static FastReader sc = new FastReader();
    final static String INPUT_FILE = "B_sample.txt";
    final static String OUTPUT_FILE = "B1_sample_out.txt";
    // final static String INPUT_FILE = "sum_41_chapter_1_input.txt";
    // final static String OUTPUT_FILE = "B1_fin_out.txt";
    // final static String INPUT_FILE = "sum_41_chapter_1_validation_input.txt";
    // final static String OUTPUT_FILE = "B1_validation_out.txt";
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

            long P = sc.nextLong();
            solveCase(P, c + 1);
        }

        outputWriter.close();
        writeOutputToFile(output.toString().trim(), OUTPUT_FILE);
    }

    public static void solveCase(long number, int caseNumber) {
        List<Long> result = new ArrayList<>();
        //System.out.println("P: "+number);
        if (number == 41) {
            outputWriter.println("Case #" + caseNumber + ": 1 41");
            return;
        }
    
        //for (long prime : new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
        for (long prime = 41; prime >= 0; prime--) {
            while (number % prime == 0) {
                if (result.size() > 98) {
                    outputWriter.println("Case #" + caseNumber + ": -1");
                    return;
                }
                //System.out.println("Adding "+prime);
                result.add(prime);
                number /= prime;
            }
        }
        
        if (number != 1 || result.stream().mapToLong(Long::longValue).sum() > 41) {
            outputWriter.println("Case #" + caseNumber + ": -1");
            return;
        }
        while (result.stream().mapToLong(Long::longValue).sum() < 41) {
            result.add(1L);
        }
    
        outputWriter.println("Case #" + caseNumber + ": " + result.size() + " " + result.stream().map(Object::toString).collect(Collectors.joining(" ")));
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