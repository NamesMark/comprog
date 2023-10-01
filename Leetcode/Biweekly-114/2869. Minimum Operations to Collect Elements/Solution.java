class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int len = nums.size();
        Set<Integer> set = new HashSet<>();
        int ops = 0;
        
        for (int i = len-1; i>=0; i--) {
            if (set.size()>=k) {
                break;
            }
            int num = nums.get(i);
            if (num <= k && !set.contains(num)) {
                set.add(num);
            }
            ops++;
        }
        
        if (set.size()<k) {
            return -1;
        }
        
        return ops;
    }
}