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

        Map<Integer, Set<Integer>> trustMap = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            trustMap.computeIfAbsent(trust[i][0], k -> new HashSet<>()).add(trust[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            if (!trustMap.containsKey(i)) {
                boolean possibleJudge = true;
                for (int j = 1; j <= n; j++) {
                    if (i != j && (!trustMap.containsKey(j) || !trustMap.get(j).contains(i))) {
                        possibleJudge = false;
                        break;
                    }
                }
                if (possibleJudge) {
                    return i;
                }
            }
        }

        return -1;
    }
}