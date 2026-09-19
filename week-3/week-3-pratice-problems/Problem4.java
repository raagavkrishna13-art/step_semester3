import java.util.Arrays;

public class Problem4 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result

        // Compare elements and copy the smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1 if any
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 if any
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] merged1 = mergeSortedArrays(new int[] { 1, 3, 5 }, new int[] { 2, 4, 6 });
        System.out.println(Arrays.toString(merged1));

        int[] merged2 = mergeSortedArrays(new int[] {}, new int[] { 1, 2, 3 });
        System.out.println(Arrays.toString(merged2));
    }
}