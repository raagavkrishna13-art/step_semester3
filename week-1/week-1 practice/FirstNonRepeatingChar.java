import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        // Frequency array for standard ASCII characters
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Early-exit scan: left to right
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character exists
    }

    private static void processString(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.println("Input String : \"" + text + "\"");
        if (result != '\0') {
            System.out.println("Output       : First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Output       : No Non-Repeating Character Found");
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("========== UNIQUE LETTER HUNT MINI-GAME ==========");
        processString("swiss");
        processString("aabbcc");
        processString("code learning platform");
    }
}