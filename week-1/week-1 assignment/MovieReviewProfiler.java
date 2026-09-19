public class MovieReviewProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip punctuation for accurate letter count
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int len = cleanWord.length();

            if (len > 0) {
                if (len <= 4) {
                    shortCount++;
                } else if (len <= 8) {
                    mediumCount++;
                } else {
                    longCount++;
                }
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1 ===");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}