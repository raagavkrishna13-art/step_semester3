public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    return; // Exit after finding the first duplicate pair
                }
            }
        }
        
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1 ===");
        int[] seats1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats1);

        System.out.println("\n=== Test Case 2 ===");
        int[] seats2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seats2);
    }
}