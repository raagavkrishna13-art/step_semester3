public class PalindromeChecker {

    // Approach 1: Iterative Comparison
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive Check
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    private static void verifyPalindrome(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean iterativeRes = isPalindromeIterative(cleaned);
        boolean recursiveRes = isPalindromeRecursive(cleaned);
        boolean arrayRes = isPalindromeArrayReversal(cleaned);

        System.out.println("Input: \"" + text + "\"");
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                iterativeRes ? "Palindrome" : "Not Palindrome",
                recursiveRes ? "Palindrome" : "Not Palindrome",
                arrayRes ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        System.out.println("================ QA PALINDROME VERIFICATION ================");
        verifyPalindrome("madam");
        verifyPalindrome("hello");
        verifyPalindrome("racecar");
    }
}