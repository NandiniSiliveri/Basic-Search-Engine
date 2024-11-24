import java.util.*;

public class SearchHandler {
    private final Trie trie;

    public SearchHandler() {
        trie = new Trie();
    }

    public void loadTopics(List<String> topics) {
        for (String topic : topics) {
            trie.insert(topic);
        }
    }

    public List<String> search(String query) {
        return trie.search(query);
    }
}
