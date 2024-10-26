class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sumOfSqrs = 0;
        for (int i = 0; i < n; i++) {
           for (int j = i; j < n; j++) {
               Set<Integer> uniq = new HashSet<>();
               for (int l = i; l <= j; l++) {
                   uniq.add(nums.get(l));
               }
               sumOfSqrs += Math.pow(uniq.size(), 2);
           }
        }
    
        return sumOfSqrs;
    }
}