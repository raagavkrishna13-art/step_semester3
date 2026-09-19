import java.util.*;

public class Problem5 {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) return;

        // Set of stop words for easy lookup
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize text: lowercase and strip punctuation (commas and periods)
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        // Split into words using whitespace pattern
        String[] words = cleaned.split("\\s+");

        // Count frequencies of non-stop words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list and sort descending by frequency count
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print frequency report
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String sampleFeedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(sampleFeedback);
    }
}