import java.util.*;

public class SearchEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchHandler searchHandler = new SearchHandler();

        System.out.println("Loading topics...");
        List<String> topics = FileLoader.loadTopics("C:/Users/siliv/OneDrive/Desktop/searchengine/data/topics.txt");
        searchHandler.loadTopics(topics);
        System.out.println("Topics loaded successfully!");

        while (true) {
            System.out.print("Enter search query (or type 'exit' to quit): ");
            String query = scanner.nextLine();
            if (query.equalsIgnoreCase("exit")) {
                break;
            }
            List<String> results = searchHandler.search(query);
            if (results.isEmpty()) {
                System.out.println("No results found.");
            } else {
                System.out.println("Search results:");
                for (String result : results) {
                    System.out.println("- " + result);
                }
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Search Engine!");
    }
}
