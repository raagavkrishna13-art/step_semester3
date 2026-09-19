public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-indexed position
                    origChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matched / total) * 100.0;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);

        if (matched == total) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n", 
                    firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1 ===");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\n=== Test Case 2 ===");
        checkTypingAccuracy("coding", "coding");
    }
}