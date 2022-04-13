package trie;

public class Trie {
    public static void main(String[] args) {
        String[] words = {"amrit", "abhinav", "aniket", "anish", "shubhi", "nepal", "aamrit"};
        TrieNode dictionary = new TrieNode();
        for (String word : words) {
            insert(dictionary, word);
        } 
        System.out.println("Is amrit in ?" + search(dictionary, "amrit"));
        System.out.println("Is akash in ?" + search(dictionary, "akash"));
    }

    public static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isLast = false;
    }

    public static void insert(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.nodes[ch - 'a'] == null) {
                root.nodes[ch - 'a'] = new TrieNode();
            }
            root = root.nodes[ch - 'a'];
            if (i == word.length() - 1) {
                root.isLast = true;
            }
        }
    }

    public static boolean search(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.nodes[ch - 'a'] == null) {
                return false;
            }
            root = root.nodes[ch - 'a'];
        }
        return root.isLast;
    }
}