import java.util.*;
import java.io.*;

public class B {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        final int MAX_OPS = 3;
        
        int t = sc.nextInt();

        while (--t >= 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            List<Integer> numbers = new ArrayList<>();
            numbers.add(a);
            numbers.add(b);
            numbers.add(c);

            boolean res = false;

            for (int i = 0; i < MAX_OPS; i++) {      
                //System.out.println("BEFORE iteration "+i+": "+numbers.toString());        
                if (areAllEq(numbers)) {
                    res = true;
                    //System.out.println("ALL GOOD");
                    break;
                } else {
                    Collections.sort(numbers);
                    //System.out.println("SORTED: "+numbers.toString());    
                    int len = numbers.size();
                    int largest = numbers.get(len-1);
                    int smallest = numbers.get(0);

                    if (largest == numbers.get(len-2)+numbers.get(len-3)) {
                        // cut largest into two smaller if it matches their sum: e.g. 2,3,5 - cut 5 into 2 and 3
                        numbers.remove(len-1);
                        numbers.add(numbers.get(len-2));
                        numbers.add(numbers.get(len-3));
                        
                    } else if (largest == (numbers.get(len-2)*2 + numbers.get(len-3))) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(len-2)*2);
                        numbers.add(numbers.get(len-3));
                    } else if (largest == (numbers.get(len-2) + numbers.get(len-3)*2)) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(len-2));
                        numbers.add(numbers.get(len-3)*2);
                    } else if (largest == (numbers.get(len-2) + numbers.get(len-3)*3)) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(len-2));
                        numbers.add(numbers.get(len-3)*3);
                    } else if (largest == (numbers.get(len-2)*3 + numbers.get(len-3))) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(len-2)*3);
                        numbers.add(numbers.get(len-3));
                    } else if (largest == smallest*2) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(0));
                        numbers.add(numbers.get(0));
                    } else if (largest == numbers.get(1)*2) {
                        numbers.remove(len-1);
                        numbers.add(numbers.get(1));
                        numbers.add(numbers.get(1));
                    }
                }
                //System.out.println("AFTER: "+numbers.toString());
                if (areAllEq(numbers)) {
                    res = true;
                    //System.out.println("ALL GOOD");
                    break;
                }
            }


            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean areAllEq(List<Integer> list) {
        return list.stream()
          .distinct()
          .count() <= 1;
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