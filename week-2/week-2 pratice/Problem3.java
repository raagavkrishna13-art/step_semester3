public class Problem3 {
    public static String validateFileExtension(String filename) {
        int lastIndex = filename.lastIndexOf('.');

        // Ensure dot exists and is not the last character
        if (lastIndex == -1 || lastIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastIndex + 1);

        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}