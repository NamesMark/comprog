import java.util.*;
import java.io.*;

public class Solution {

    //static FastReader sc;
    final static String INPUT_FILE = "two_apples_a_day_input.txt";
    final static String OUTPUT_FILE = "C_full_out.txt";
    private static StringWriter output;
    private static PrintWriter outputWriter;

    public static String solve(int n, int length, int[] arr, int caseNumber) {
        int result = 0;

        if (length == 1) {
            return "Case #"+ caseNumber +": " + 1;
        }

        int[] sortArr = arr.clone();
        int[] testArr = new int[length+1];
        // int mutN = n;

        Arrays.sort(sortArr);

        int sumCand = -1;
        int insertCand = -1;

        // hypothesis 1: arr[0] is pairless
        sumCand = sortArr[1] + sortArr[length-1];
        insertCand = sumCand - sortArr[0];
        // System.out.println("Hypothesis: sum is " + sumCand + ", insert number: " + insertCand);
        testArr = insertIntoSorted(sortArr, insertCand);
        int res1 = insertCand;
        res1 = testArrayWithCandidate(length+1, testArr, sumCand, insertCand);
        
        // hypothesis 2: arr[-1] is pairless
        sumCand = sortArr[0] + sortArr[length-1-1];
        insertCand = sumCand - sortArr[length-1];
        // System.out.println("Hypothesis: sum is " + sumCand + ", insert number: " + insertCand);
        testArr = insertIntoSorted(sortArr, insertCand);
        int res2 = insertCand;
        res2 = testArrayWithCandidate(length+1, testArr, sumCand, insertCand);

        // hypothesis 3: pairless in the middle
        sumCand = sortArr[0] + sortArr[length-1];
        int insertCand31 = -1;
        int insertCand32 = -1;
        for (int i = 1; i <= length/2; i++) {
            if (sortArr[i] + sortArr[length-1-i] != sumCand) {
                // hypothesis 3.1: pairless arr[i]
                insertCand31 = sumCand - sortArr[i];
                // hypothesis 3.2: pairless arr[length-1-i]
                insertCand32 = sumCand - sortArr[length-1-i];
                break;
            }
        }
        // System.out.println("Hypothesis: sum is " + sumCand + ", insert number: " + insertCand31);
        // System.out.println("Hypothesis: sum is " + sumCand + ", insert number: " + insertCand32);
        testArr = insertIntoSorted(sortArr, insertCand31);
        // System.out.println(Arrays.toString(testArr));
        int res31 = testArrayWithCandidate(length+1, testArr, sumCand, insertCand31);
        testArr = insertIntoSorted(sortArr, insertCand32);
        // System.out.println(Arrays.toString(testArr));
        int res32 = testArrayWithCandidate(length+1, testArr, sumCand, insertCand32);
        // hypothesis 4: arr[length/2]
        int insertCand4 = sortArr[length/2];
        // System.out.println("Hypothesis: sum is " + sumCand + ", insert number: " + insertCand4);
        testArr = insertIntoSorted(sortArr, insertCand4);
        int res4 = testArrayWithCandidate(length+1, testArr, sumCand, insertCand4);

        List<Integer> resultCandidates = Arrays.asList(res1, res2, res31, res32, res4);
        List<Integer> resultCandidatesSifted = new ArrayList<>();

        for (Integer res: resultCandidates) {
            if (res>0) {
                resultCandidatesSifted.add(res);
            }
        }

        if (resultCandidatesSifted.size() > 0) {

            result = Collections.min(resultCandidatesSifted);
        } else {
            result = -1;
        }



        if (result <= 0) {
            result = -1;
        }
        // } else {
        //     result = "NO";
        // }

		return "Case #"+ caseNumber +": " + result;
    }

    private static int testArrayWithCandidate(int length, int[] testArr, int sumCand, int insertCand) {
        int res = insertCand;
        for (int i = 0; i <= length/2; i++) {
            if (testArr[i] + testArr[length-i-1] != sumCand) {
                res = -1;
                break;
            }
        }
        return res;
    }

    public static int[] insertIntoSorted(int[] sortArr, int newVal) {
        int n = sortArr.length;
        int[] newArr = new int[n + 1];

        int i;
        for (i = 0; i < n; i++) {
            if (sortArr[i] > newVal) {
                break;
            }
            newArr[i] = sortArr[i];
        }

        newArr[i] = newVal;

        while (i < n) {
            newArr[i + 1] = sortArr[i];
            i++;
        }

        return newArr;
    }

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
        output = new StringWriter();
        outputWriter = new PrintWriter(output);

        int testCases = sc.nextInt();
		int totalTestCases = testCases;
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int inputLength = n*2 - 1;
            // int inputLength = sc.nextInt();
            //int k = sc.nextInt();
            // long[] testCaseArray = new long[inputLength];
            // for (int i = 0; i < inputLength; i++) {
            //     testCaseArray[i] = sc.nextLong();
            // }
            int[] testCaseArray = new int[inputLength];
            for (int i = 0; i < inputLength; i++) {
                testCaseArray[i] = sc.nextInt();
            }
			int caseNumber = totalTestCases-testCases;
            outputWriter.println(solve(n, inputLength, testCaseArray, caseNumber));
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