import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Integer> result = solve(n);
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
    
    private static List<Integer> solve(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        while (true) {
            Collections.shuffle(nums);
            if (check(nums)) {
                return nums;
            }
        }
    }
    
    private static boolean check(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            set.add((nums.get(i) + nums.get(i + 1)) % nums.size());
        }
        return set.size() == nums.size() - 1;
    }
}