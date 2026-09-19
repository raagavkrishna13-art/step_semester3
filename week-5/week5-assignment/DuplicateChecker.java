public class DuplicateChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        // Pairwise comparison checking only forward elements
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }
}