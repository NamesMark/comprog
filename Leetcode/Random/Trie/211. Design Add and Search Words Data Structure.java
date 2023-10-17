class WordDictionary {
    class Node {
        public Map<Character, Node> children;
        public boolean isEnd;
        //public Node next;

        public Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                Node newNode = new Node();
                curr.children.put(c, newNode);
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        char[] characters = word.toCharArray();
        return dfsSearch(root, characters, 0);
    }

    private boolean dfsSearch(Node node, char[] characters, int index) {
        if (index == characters.length) {
            return node.isEnd;
        }

        char currChar = characters[index];
        if (currChar == '.') {
            for (Map.Entry<Character, Node> entry:node.children.entrySet()) {
                if(dfsSearch(entry.getValue(), characters, index + 1)) {
                    return true;
                }
            }
        } else if (node.children.containsKey(currChar)) {
            return dfsSearch(node.children.get(currChar), characters, index + 1);
        } 
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */