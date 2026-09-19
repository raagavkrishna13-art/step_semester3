public class CustomerNameReverser {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);

        System.out.println("========== CUSTOMER IDENTITY VERIFICATION ==========");
        System.out.println("Original Name : " + originalName);
        System.out.println("Reversed Name : " + reversedName);
        System.out.println("Original Maintained: " + originalName.equals("Sunil"));
    }
}