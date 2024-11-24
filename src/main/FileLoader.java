import java.io.*;
import java.util.*;

public class FileLoader {
    public static List<String> loadTopics(String filePath) {
        List<String> topics = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                topics.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error loading topics: " + e.getMessage());
        }
        return topics;
    }
}
