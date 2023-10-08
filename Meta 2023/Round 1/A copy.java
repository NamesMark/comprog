import java.util.*;
import java.io.*;

public class A {

    //static FastReader sc = new FastReader();
    final static String INPUT_FILE = "here_comes_santa_claus_validation_input.txt";
    final static String OUTPUT_FILE = "A_validation.txt";
    private static StringWriter output;
    private static PrintWriter outputWriter;

    public static void main(String[] args) {
        
        FastReader sc = null;
        try {
            sc = new FastReader(INPUT_FILE);
            // ... (use the reader to read data from the file)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        int cases = sc.nextInt();

        output = new StringWriter();
        outputWriter = new PrintWriter(output);

        for (int c = 0; c < cases; c++) {
            int numElves = sc.nextInt();

            int[] elves = new int[numElves];
            for (int i = 0; i < numElves; i++) {
                elves[i] = sc.nextInt();
            }

            Arrays.sort(elves);
            // double left = 0;
            // double right = 0;

            // if (numElves % 2 == 0) {
            //     left = (elves[0]+elves[1]) / 2.0;
            //     right = (elves[numElves-1] + elves[numElves-2]) / 2.0;
            // } else {
            //     if (elves[2]-elves[1] >= elves[numElves-2] - elves[numElves-3]) {
            //         left = (elves[0]+elves[1]) / 2.0;
            //         right = (elves[numElves-1] + elves[numElves-2]+ elves[numElves-3]) / 3;
            //     } else {
            //         left = (elves[0]+elves[1]+elves[2]) / 3.0;
            //         right = (elves[numElves-1] + elves[numElves-2]) / 2.0;
            //     }
            // }
            double result;

            double firstPair = (elves[0] + elves[1]) / 2.0;
            double lastPair = (elves[numElves - 1] + elves[numElves - 2]) / 2.0;

            if (numElves % 2 == 0) {
                result = lastPair-firstPair;
            } else {
                double firstThree = (elves[0] + elves[1] + elves[2]) / 3.0;
                
                double lastThree = (elves[numElves - 1] + elves[numElves - 2] + elves[numElves - 3]) / 3.0;
                
                result = Math.max(lastThree - firstPair, lastPair - firstThree);

                if (numElves > 5) {
                    result = Math.max(result, lastPair-firstPair);
                }

                // System.out.println("lastThree - firstPair: "+(lastThree - firstPair));
                // System.out.println("lastPair - firstThree: "+(lastPair - firstThree));
                // System.out.println("lastPair-firstPair: "+(lastPair-firstPair));


            }
    
            //System.out.println("Case #"+c+": "+Math.abs(result));
            outputWriter.println("Case #"+(c+1)+": "+Math.abs(result));

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