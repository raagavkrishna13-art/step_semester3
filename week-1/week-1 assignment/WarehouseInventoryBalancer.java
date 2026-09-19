public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        for (int val : sectionA) {
            totalA += val;
        }

        int totalB = 0;
        for (int val : sectionB) {
            totalB += val;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxVal = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-indexed item position
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxVal, maxSection, maxIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Test Case 1 ===");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}