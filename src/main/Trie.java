import java.util.*;

public class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(c)) {
                return Collections.emptyList();
            }
            current = current.children.get(c);
        }
        return collectAllWords(current, prefix);
    }

    private List<String> collectAllWords(TrieNode node, String prefix) {
        List<String> words = new ArrayList<>();
        if (node.isEndOfWord) {
            words.add(prefix);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            words.addAll(collectAllWords(entry.getValue(), prefix + entry.getKey()));
        }
        return words;
    }
}
