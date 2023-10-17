class Solution {
    public int findJudge(int n, int[][] trust) {
        // intuition:
        // this seems like a star graph
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        if (trust.length == 1) {
            return trust[0][1];
        }

        int[] trusts = new int[n+1];
        int[] trusted = new int[n+1];

        for (int[] relation : trust) {
            trusts[relation[0]]++;
            trusted[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trusted[i] == n-1 && trusts[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}