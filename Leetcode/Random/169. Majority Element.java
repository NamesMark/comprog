class Solution {
    public int majorityElement(int[] nums) {
        int top = -1;
        int count = 0;

        for (int num: nums) {
            if (num != top) {
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                top = num;
                count = 1;
            }
        }

        return top;
    }
}