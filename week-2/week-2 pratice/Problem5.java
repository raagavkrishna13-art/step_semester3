public class Problem5 {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters, keep remainder unchanged
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String rawReference) {
        String ref = normalizeReference(rawReference);

        // 1. Length check
        if (ref.length() != 14) {
            return "Invalid: wrong length";
        }

        // 2. First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 3. Remaining 11 characters must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Build formatted string
        String bankCode = ref.substring(0, 3);
        String day = ref.substring(3, 5);
        String month = ref.substring(5, 7);
        String year = ref.substring(7, 9);
        String seq = ref.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
          .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}