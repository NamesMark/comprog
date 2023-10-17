class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> children = new HashMap<>(); // node, parent

        // map children to their parents skipping empty (-1)
        // return false if more than 1 parent
        for (int i = 0; i < leftChild.length; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if ((left != -1 && children.put(left, i) != null) || 
                (right != -1 && children.put(right, i) != null)) {
                return false;
            }
        }

        // determine root
        // return false if more than 1 root
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!children.containsKey(i)) {
                if (root != -1) return false; 
                root = i;
            }
        }
        if (root == -1) return false;

        // // return false if wrong number of children
        // if (children.size() != n-1) {
        //     return false;
        // }

        // check for cycles and whether all nodes are reachable by DFS from root
        Set<Integer> visited = new HashSet<>();
        boolean ans = dfs(root, leftChild, rightChild, visited) && visited.size() == n;
        System.gc();
        return ans;
    }

    private boolean dfs(int node, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        if ((leftChild[node] != -1 && !dfs(leftChild[node], leftChild, rightChild, visited)) ||
            (rightChild[node] != -1 && !dfs(rightChild[node], leftChild, rightChild, visited))) {
                return false;
            }
            
        return true;
    }
}